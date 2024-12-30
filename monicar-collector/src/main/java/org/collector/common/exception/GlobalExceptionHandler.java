package org.collector.common.exception;

import org.collector.common.response.CommonResponse;
import org.collector.common.response.ResponseCode;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler{
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public CommonResponse<Object> handleMethodArgumentNotValid(
		MethodArgumentNotValidException ex
	) {
		String errorMessage = ex.getBindingResult().getAllErrors()
			.stream()
			.map(ObjectError::getDefaultMessage)
			.findFirst()
			.orElse("Validation error");

		return CommonResponse.fail(new CustomException(ResponseCode.REQUIRED_PARAMETER_ERROR), errorMessage);
	}
}
