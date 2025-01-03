package org.emulator.device.infrastructure.external.command;

import java.util.List;

public record CycleInfoListCommand(
	String mdn,
	String tid,
	String mid,
	String pv,
	String did,
	String cCnt,
	List<CycleInfoCommand> cList
) {}
