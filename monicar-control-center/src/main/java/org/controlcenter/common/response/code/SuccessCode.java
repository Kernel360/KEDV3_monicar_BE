package org.controlcenter.common.response.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SuccessCode {
	OK("요청 성공"),
	CREATED("생성 완료"),
	UPDATED("수정 완료"),
	DELETED("삭제 완료");

	private final String message;
}