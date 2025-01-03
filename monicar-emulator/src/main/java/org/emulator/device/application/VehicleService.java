package org.emulator.device.application;

import java.util.Deque;
import java.util.LinkedList;

import org.common.dto.CommonResponse;
import org.emulator.device.application.port.EmulatorRepository;
import org.emulator.device.application.port.LocationReceiver;
import org.emulator.device.application.port.VehicleCommandSender;
import org.emulator.device.domain.CycleInfo;
import org.emulator.device.domain.GpsStatus;
import org.emulator.device.domain.OnInfo;
import org.emulator.device.infrastructure.GpsTime;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class VehicleService {
	private final EmulatorRepository emulatorRepository;
	private final LocationReceiver locationReceiver;
	// private final LocationEventPublisher locationEventPublisher; // 추후 주기 정보를 이벤트로 쏠 때
	private final VehicleCommandSender vehicleCommandSender;

	private static final Deque<CycleInfo> cycleInfos = new LinkedList<>();

	public void onVehicle() {
		GpsTime onLocation = locationReceiver.getLocation();

		OnInfo onInfo = OnInfo.create(
			onLocation.intervalAt(),
			GpsStatus.A,
			onLocation.location().lat(),
			onLocation.location().lon(),
			emulatorRepository.getTotalDistance()
		);

		CommonResponse response = vehicleCommandSender.sendOnCommand(onInfo);
	}
}
