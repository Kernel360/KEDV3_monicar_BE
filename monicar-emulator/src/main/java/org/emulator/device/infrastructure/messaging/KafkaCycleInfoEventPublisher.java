package org.emulator.device.infrastructure.messaging;

import org.emulator.device.application.port.CycleInfoEventPublisher;
import org.emulator.device.domain.CycleInfo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Qualifier("kafkaCycleInfoEventPublisher")
@Component
public class KafkaCycleInfoEventPublisher implements CycleInfoEventPublisher {
	@Override
	public void publishEvent(List<CycleInfo> cycleInfoList) {
		// TODO: kafka 이벤트 발행
	}
}
