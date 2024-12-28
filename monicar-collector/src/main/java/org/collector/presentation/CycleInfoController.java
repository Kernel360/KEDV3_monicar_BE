package org.collector.presentation;

import org.collector.application.CycleInfoService;
import org.collector.common.response.CommonResponse;
import org.common.dto.CycleInfoRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequestMapping("/api/cycle-info")
@RestController
@RequiredArgsConstructor
public class CycleInfoController {

	private final CycleInfoService cycleInfoService;

	@PostMapping
	public CommonResponse<Void> cycleInfoSave(final @RequestBody CycleInfoRequest request) {
		cycleInfoService.cycleInfoSave(request);
		return CommonResponse.ok("111");
	}
}
