package org.collector.presentation;

import org.collector.application.CycleInfoService;
import org.common.dto.CycleInfoRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/api/cycle-info")
@RestController
@RequiredArgsConstructor
@Slf4j
public class CycleInfoController {

	private final CycleInfoService cycleInfoService;

	@PostMapping
	public void cycleInfoSave(@RequestBody CycleInfoRequest request) {
		cycleInfoService.cycleInfoSave(request);
	}
}
