package org.emulator.device.domain;

import java.time.LocalDateTime;

import org.emulator.device.VehicleConstant;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OnInfo {
	private LocalDateTime onTime;
	private LocalDateTime offTime;
	private GpsStatus gpsStatus;
	private long latitude;
	private long longitude;
	private int direction;
	private int speed;
	private int totalDistance;

	public static OnInfo create(
		LocalDateTime onTime,
		GpsStatus gpsStatus,
		double latitude,
		double longitude,
		int totalDistance
	) {
		long lat = (long)(latitude * VehicleConstant.MIL);
		long lon = (long)(longitude * VehicleConstant.MIL);

		return OnInfo.builder()
			.onTime(onTime)
			.offTime(null)
			.gpsStatus(gpsStatus)
			.latitude(lat)
			.longitude(lon)
			.direction(0)
			.speed(0)
			.totalDistance(totalDistance)
			.build();
	}
}
