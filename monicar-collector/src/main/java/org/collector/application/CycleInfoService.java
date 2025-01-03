package org.collector.application;

import java.util.List;

import org.collector.domain.CycleInfo;
import org.collector.infrastructure.repository.CycleInfoRepository;
import org.collector.presentation.dto.CycleInfoRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CycleInfoService {
	private final CycleInfoRepository cycleInfoRepository;

	@Transactional
	public void cycleInfoSave(final CycleInfoRequest request) {
		List<CycleInfo> cycleInfos = request.cList().stream()
			.map(cListRequest -> CycleInfo.builder()
				.interval_at(cListRequest.interval_at())
				.gcd(cListRequest.gcd())
				.lat(CycleInfo.convertToSixDecimalPlaces(cListRequest.lat()))
				.lon(CycleInfo.convertToSixDecimalPlaces(cListRequest.lon()))
				.ang(cListRequest.ang())
				.spd(cListRequest.spd())
				.sum(cListRequest.sum())
				.bat(cListRequest.bat())
				.build()
			)
			.toList();

		cycleInfoRepository.saveAll(cycleInfos);
	}
}
