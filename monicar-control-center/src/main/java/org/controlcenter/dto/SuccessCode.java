package org.controlcenter.dto;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SuccessCode {
    OK(HttpStatus.OK, "요청 성공"),
    CREATED(HttpStatus.CREATED, "생성 완료"),
    UPDATED(HttpStatus.OK, "수정 완료"),
    DELETED(HttpStatus.OK, "삭제 완료");

    private final HttpStatus status; // HTTP 상태 코드
    private final String message; // 오류 메시지
}