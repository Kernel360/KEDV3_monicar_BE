package org.emulator.domain.dto;

/**
 * 차량의 제어 정보 데이터를 담는 레코드
 *
 * @param ctrId 제어 정보 아이디 - 제어 정보를 식별하는 고유 번호
 * @param ctrCd 제어 정보 코드 - 주기정보 전송 주기 코드 (‘05’ 고정)
 * @param ctrVal 제어 정보 값 - 주기정보 전송 주기(단위: 초) (60, 120 . .)
 */
public record CtrListDto (
    String ctrId,
    String ctrCd,
    String ctrVal
) {}
