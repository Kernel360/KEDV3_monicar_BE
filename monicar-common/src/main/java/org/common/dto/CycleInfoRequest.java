package org.common.dto;

import java.util.List;

public record CycleInfoRequest(
	String mdn,
	String tid,
	String mid,
	String pv,
	String did,
	String oTime,
	String cCnt,
	List<CListRequest> cList
) {
}
