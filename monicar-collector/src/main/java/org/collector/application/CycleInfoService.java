package org.collector.application;

import java.util.List;

import org.collector.domain.CycleInfo;
import org.collector.infrastructure.repository.CycleInfoRepository;
import org.common.dto.CycleInfoRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CycleInfoService {
	private final CycleInfoRepository cycleInfoRepository;

	@Transactional
	public void cycleInfoSave(CycleInfoRequest request) {
		List<CycleInfo> cycleInfos = request.cList().stream()
			.map(cListRequest -> new CycleInfo(
				cListRequest.sec(),
				cListRequest.gcd(),
				cListRequest.lat(),
				cListRequest.lon(),
				cListRequest.ang(),
				cListRequest.spd(),
				cListRequest.sum(),
				cListRequest.bat()
			))
			.toList();

		cycleInfoRepository.saveAll(cycleInfos);
	}
}
