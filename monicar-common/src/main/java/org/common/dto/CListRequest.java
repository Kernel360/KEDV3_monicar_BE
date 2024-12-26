package org.common.dto;

public record CListRequest(
	String sec,
	String gcd,
	String lat,
	String lon,
	String ang,
	String spd,
	String sum,
	String bat
) {
}
