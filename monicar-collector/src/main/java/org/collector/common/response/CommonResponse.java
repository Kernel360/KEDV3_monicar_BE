package org.collector.common.response;

import org.collector.common.exception.CustomException;

import jakarta.annotation.Nullable;

public record CommonResponse<T>(
	String rstCd,
	String rstMsg,
	String mdn
) {
	public static <T> CommonResponse<T> ok(@Nullable final String mdn) {
		return new CommonResponse<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), mdn);
	}

	public static <T> CommonResponse<T> fail(final CustomException e, @Nullable final String mdn) {
		return new CommonResponse<>(e.getResponseCode().getCode(), e.getMessage(), mdn);
	}
}
