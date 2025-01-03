package org.emulator.device.infrastructure;

import lombok.RequiredArgsConstructor;

import org.emulator.device.application.port.CycleInfoEventPublisher;
import org.emulator.device.domain.CycleInfo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.List;

@Qualifier("applicationCycleInfoEventPublisher")
@RequiredArgsConstructor
@Component
public class ApplicationCycleInfoEventPublisher implements CycleInfoEventPublisher {
	private final ApplicationEventPublisher eventPublisher;

	@Override
	public void publishEvent(List<CycleInfo> cycleInfoList) {
		eventPublisher.publishEvent(cycleInfoList);
	}
}
