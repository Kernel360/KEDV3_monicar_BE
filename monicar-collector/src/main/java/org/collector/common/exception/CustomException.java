package org.collector.common.exception;

import org.collector.common.response.ResponseCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CustomException extends RuntimeException {
	private final ResponseCode responseCode;

	public String getMessage() {
		return responseCode.getMessage();
	}
}
