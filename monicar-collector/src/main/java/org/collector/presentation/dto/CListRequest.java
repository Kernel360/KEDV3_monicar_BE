package org.collector.presentation.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record CListRequest(
	@NotNull(message = "발생시간은 필수 입력값입니다.")
	Integer sec,

	@NotNull(message = "유효하지 않은 GPS상태 값이 입력되었습니다.")
	GCD gcd,

	@NotNull(message = "GPS 위도는 필수 입력값입니다.")
	@DecimalMin(value = "-90.0", message = "위도는 -90.0 ~ 90.0 사이여야 합니다.")
	@DecimalMax(value = "90.0", message = "위도는 -90.0 ~ 90.0 사이여야 합니다.")
	@Digits(integer = 2, fraction = 6, message = "위도는 소수점 6자리까지 입력 가능합니다.")
	Double lat,

	@NotNull(message = "GPS 경도는 필수 입력값입니다.")
	@DecimalMin(value = "-180.0", message = "경도는 -180.0 ~ 180.0 사이여야 합니다.")
	@DecimalMax(value = "180.0", message = "경도는 -180.0 ~ 180.0 사이여야 합니다.")
	@Digits(integer = 3, fraction = 6, message = "경도는 소수점 6자리까지 입력 가능합니다.")
	Double lon,

	@NotNull(message = "방향은 필수 입력값입니다.")
	@Min(value = 0, message = "방향은 0 ~ 365 사이여야 합니다.")
	@Max(value = 365, message = "방향은 0 ~ 365 사이여야 합니다.")
	Integer ang,

	@NotNull(message = "속도는 필수 입력값입니다.")
	@Min(value = 0, message = "속도는 0 ~ 255 사이여야 합니다.")
	@Max(value = 255, message = "속도는 0 ~ 255 사이여야 합니다.")
	Integer spd,

	@NotNull(message = "누적 주행거리는 필수 입력값입니다.")
	@Min(value = 0, message = "누적 주행거리는 0 ~ 9999999 사이여야 합니다.")
	@Max(value = 9999999, message = "누적 주행거리는 0 ~ 9999999 사이여야 합니다.")
	Integer sum,

	@NotNull(message = "배터리 전압은 필수 입력값입니다.")
	@Min(value = 0, message = "배터리 전압은 0 ~ 9999 사이여야 합니다.")
	@Max(value = 9999, message = "배터리 전압은 0 ~ 9999 사이여야 합니다.")
	Integer bat
) {
}


