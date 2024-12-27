package org.controlcenter.dto;

import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;

/**
 * API 요청에 대한 응답 표준화 클래스
 *
 * @param <T> 요청의 결과 데이터 타입
 */
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse<T> {
	private final Boolean isSuccess; // 상태 코드에 따른 Boolean
	private final String message;    // 에러 설명 또는 성공 메시지

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private final T result;          // 요청 성공 시 반환되는 결과 데이터

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private final Integer code;      // 성공 또는 오류 코드

	// 생성자
	private BaseResponse(Boolean isSuccess, String message, T result, Integer code) {
		this.isSuccess = isSuccess;
		this.message = message;
		this.result = result;
		this.code = code;
	}

	// 성공 응답 생성 메서드

	/**
	 * 성공 응답 생성 메서드 - 데이터와 성공 코드를 포함하여 응답
	 *
	 * @param <T>  응답 데이터 타입
	 * @param code 성공 상태 코드 (SuccessCode)
	 * @param data 응답 데이터
	 * @return 성공 응답 포함한 ResponseEntity 객체
	 */
	public static <T> ResponseEntity<BaseResponse<T>> success(SuccessCode code, T data) {
		return ResponseEntity
			.status(code.getStatus())
			.body(new BaseResponse<>(true, code.getMessage(), data, null));
	}

	/**
	 * 성공 응답 생성 메서드 - 기본 성공 코드와 함께 데이터만 포함하여 응답
	 *
	 * @param <T>  응답 데이터 타입
	 * @param data 응답 데이터
	 * @return 성공 응답 포함한 ResponseEntity 객체
	 */
	public static <T> ResponseEntity<BaseResponse<T>> success(T data) {
		return ResponseEntity
			.status(SuccessCode.OK.getStatus())
			.body(new BaseResponse<>(true, SuccessCode.OK.getMessage(), data, null));
	}

	/**
	 * 성공 응답 생성 메서드 - 데이터 없이 성공 코드만 포함하여 응답
	 *
	 * @param <T>  응답 데이터 타입
	 * @param code 성공 상태 코드 (SuccessCode)
	 * @return 성공 응답 포함한 ResponseEntity 객체
	 */
	public static <T> ResponseEntity<BaseResponse<T>> success(SuccessCode code) {
		return ResponseEntity
			.status(code.getStatus())
			.body(new BaseResponse<>(true, code.getMessage(), null, null));
	}

	/**
	 * 성공 응답 생성 메서드 - 기본 성공 코드만 포함하여 응답 데이터 없이 성공 상태만 반환
	 *
	 * @return 성공 응답 포함한 ResponseEntity 객체
	 */
	public static ResponseEntity<BaseResponse<Void>> success() {
		return success(SuccessCode.OK);
	}

	/**
	 * 실패 응답 생성 메서드 - 에러 코드 포함하여 응답
	 *
	 * @param <T>  응답 데이터 타입
	 * @param code 에러 코드 (ErrorCode)
	 * @return 실패 응답 포함한 BaseResponse 객체
	 */
	public static <T> BaseResponse<T> fail(ErrorCode code) {
		return new BaseResponse<>(false, code.getMessage(), null, code.getCode());
	}

	/**
	 * 실패 응답 생성 메서드 - 메세지 포함하여 응답
	 *
	 * @param <T>    응답 데이터 타입
	 * @param errMsg 에러 메세지
	 * @return 실패 응답 포함한 BaseResponse 객체
	 */
	public static <T> BaseResponse<T> fail(String errMsg) {
		return new BaseResponse<>(false, errMsg, null, 1000);
	}
}
