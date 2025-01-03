package org.emulator.device.infrastructure;

import lombok.RequiredArgsConstructor;

import org.emulator.device.application.port.CycleInfoEventPublisher;
import org.emulator.device.domain.CycleInfo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ApplicationCycleInfoEventListener {
	@Qualifier("kafkaCycleInfoEventPublisher")
	private final CycleInfoEventPublisher publisher;

	@EventListener
	@Async
	public void publishCycleInfoCommand(List<CycleInfo> cycleInfoList) {
		// Make CycleInfoListCommand with cycleInfoList

		// publish CycleInfoListCommand
	}
}
