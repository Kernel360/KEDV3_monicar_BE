package org.emulator.device.application.port;

import org.emulator.device.domain.CycleInfo;

import java.util.List;

/**
 * 주기 정보 이벤트 발행 역할
 */
public interface CycleInfoEventPublisher {
	void publishEvent(List<CycleInfo> cycleInfoList);
}
