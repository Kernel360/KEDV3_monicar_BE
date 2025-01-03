package org.emulator.device.infrastructure.external.command;

import java.time.format.DateTimeFormatter;

import org.emulator.device.VehicleConstant;
import org.emulator.device.domain.OnInfo;

/**
 * 차량의 시동 ON / OFF 상태에서 전달하는 데이터를 담는 레코드
 *
 * @param mdn     차량 번호 - 차량을 식별하는 고유 번호
 * @param tid     터미널 아이디 - 터미널 장치의 고유 식별자
 * @param mid     제조사 아이디 - 제조사를 구분하는 식별자
 * @param pv      패킷 버전 - 데이터 패킷의 버전 정보
 * @param did     디바이스 아이디 - 설치된 디바이스의 고유 식별자
 * @param onTime  시동 ON 시간
 * @param offTime 직전 시동 OFF 시간
 * @param gcd     GPS 상태 - GPS 수신 상태 ('A': 정상, 'V': 비정상, '0': 미장착, 시동 on시 비정상: 'P')
 * @param lat     GPS 위도 - 차량의 현재 위도 좌표
 * @param lon     GPS 경도 - 차량의 현재 경도 좌표
 * @param ang     방향 - 차량의 현재 진행 방향
 * @param spd     속도 - 차량의 현재 속도
 * @param sum     누적 주행 거리 - 차량의 현재 총 주행 거리
 */
public record OnCommand(
	String mdn,
	String tid,
	String mid,
	String pv,
	String did,
	String onTime,
	String offTime,
	String gcd,
	String lat,
	String lon,
	String ang,
	String spd,
	String sum
) {
	public static final int DIRECTION_MIN = 0;
	public static final int DIRECTION_MAX = 365;
	public static final int SPEED_MIN = 0;
	public static final int SPEED_MAX = 255;
	public static final int TOTAL_DISTANCE_MIN = 0;
	public static final int TOTAL_DISTANCE_MAX = 9999999;

	public static OnCommand of(OnInfo onInfo) {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

		String onTime = onInfo.getOnTime().format(dateTimeFormatter);
		String offTime = "";
		String lat = String.valueOf(onInfo.getLatitude());
		String lon = String.valueOf(onInfo.getLongitude());
		String ang = String.valueOf(Math.clamp(onInfo.getDirection(), DIRECTION_MIN, DIRECTION_MAX));
		String spd = String.valueOf(Math.clamp(onInfo.getSpeed(), SPEED_MIN, SPEED_MAX));
		String sum = String.valueOf(
			Math.clamp(onInfo.getTotalDistance(), TOTAL_DISTANCE_MIN, TOTAL_DISTANCE_MAX));

		return new OnCommand(
			VehicleConstant.VEHICLE_NUM,
			VehicleConstant.TERMINAL_ID,
			VehicleConstant.MANUFACTURER_ID,
			VehicleConstant.PACKET_VERSION,
			VehicleConstant.DEVICE_ID,
			onTime,
			offTime,
			onInfo.getGpsStatus().toString(),
			lat,
			lon,
			ang,
			spd,
			sum
		);
	}
}
