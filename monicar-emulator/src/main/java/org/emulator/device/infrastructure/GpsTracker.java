package org.emulator.device.infrastructure;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Deque;

import java.util.LinkedList;

import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.emulator.device.VehicleConstant;
import org.emulator.device.application.port.CycleInfoEventPublisher;
import org.emulator.device.application.port.LocationReceiver;
import org.emulator.device.application.port.TransmissionTimeProvider;
import org.emulator.device.domain.CycleInfo;
import org.emulator.device.domain.GpsStatus;
import org.emulator.device.infrastructure.util.Calculator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class GpsTracker implements SensorTracker {
	private final LocationReceiver locationReceiver;
	@Qualifier("emulatorTransmissionTimeProvider")
	private final TransmissionTimeProvider timeProvider;
	@Qualifier("applicationCycleInfoEventPublisher")
	private final CycleInfoEventPublisher publisher;

	private final Deque<CycleInfo> cycleInfos = new LinkedList<>();
	private CycleInfo recentCycleInfo;

	@Scheduled(initialDelay = 3000, fixedDelay = 1000)
	@Override
	public void track() {
		int time = timeProvider.getTransmissionTime();

		if (cycleInfos.size() > time) {
			List<CycleInfo> cycleInfoList = pollFromDeque(time);
			publisher.publishEvent(cycleInfoList);

			log.info("[Thread: {}] {}", Thread.currentThread().getName(), "sending!");
		}

		GpsTime currentLocation = locationReceiver.getLocation();
		// TODO: recentCycleInfo 가 null일 때 로직 개선
		if (recentCycleInfo == null) {
			CycleInfo currentCycleInfo = CycleInfo.create(
				currentLocation.intervalAt(),
				GpsStatus.A,
				currentLocation.location().lat(),
				currentLocation.location().lon(),
				0,
				0,
				0,
				VehicleConstant.BATTERY);
			cycleInfos.add(currentCycleInfo);
			recentCycleInfo = currentCycleInfo;
			return;
		}

		int distance = Calculator.calculateDistance(
			recentCycleInfo.getLatitude(),
			recentCycleInfo.getLongitude(),
			currentLocation.location().lat(),
			currentLocation.location().lon()
		);
		int speed = Calculator.calculateSpeed(
			distance,
			Duration.between(recentCycleInfo.getIntervalAt(), currentLocation.intervalAt()).toMillis()
		);
		int direction = Calculator.calculateDirection(
			recentCycleInfo.getLatitude(),
			recentCycleInfo.getLongitude(),
			currentLocation.location().lat(),
			currentLocation.location().lon()
		);
		CycleInfo currentCycleInfo = CycleInfo.create(
			currentLocation.intervalAt(),
			GpsStatus.A,
			currentLocation.location().lat(),
			currentLocation.location().lon(),
			distance,
			speed,
			direction,
			VehicleConstant.BATTERY
		);
		cycleInfos.offerLast(currentCycleInfo);
		recentCycleInfo = currentCycleInfo;

		log.info("[Thread: {}] {}", Thread.currentThread().getName(), "collecting data. . .");
	}

	public List<CycleInfo> pollFromDeque(int size) {
		List<CycleInfo> result = new ArrayList<>();
		while (!cycleInfos.isEmpty() && result.size() < size) {
			result.add(cycleInfos.pollFirst());
		}
		return result;
	}
}
