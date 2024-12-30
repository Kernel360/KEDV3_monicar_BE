package org.collector.presentation.dto;

import java.time.LocalDateTime;
import java.util.List;

import org.collector.common.annotation.CycleCount;
import org.collector.common.annotation.LocalDateTimeDeserializer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@CycleCount
public record CycleInfoRequest(
	@NotNull(message = "차량 번호는 필수 입력값입니다.")
	Long mdn,

	@NotBlank(message = "터미널 ID는 필수 입력값입니다.")
	String tid,

	@NotNull(message = "제조사 ID는 필수 입력값입니다.")
	Integer mid,

	@Min(value = 0, message = "패킷버전은 0 ~ 65535 사이여야 합니다.")
	@Max(value = 65535, message = "패킷버전은 0 ~ 65535 사이여야 합니다.")
	@NotNull(message = "패킷 버전은 필수 입력값입니다.")
	Integer pv,

	@NotNull(message = "디바이스 ID는 필수 입력값입니다.")
	Integer did,

	@NotNull(message = "발생 시간은 필수 입력값입니다.")
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	LocalDateTime oTime,

	@NotNull(message = "주기 정보 개수는 필수 입력값입니다.")
	Integer cCnt,

	List<CListRequest> cList
) {
}