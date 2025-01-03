package org.emulator.device.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import org.emulator.device.VehicleConstant;

@Builder
@Getter
public class CycleInfo {
	private LocalDateTime intervalAt;
	private GpsStatus gpsStatus;
	private long latitude;
	private long longitude;
	private int direction;
	private int speed;
	private int totalDistance;
	private int battery;

	public static CycleInfo create(
		LocalDateTime intervalAt,
		GpsStatus gpsStatus,
		double latitude,
		double longitude,
		int direction,
		int speed,
		int totalDistance,
		int battery
	) {
		long lat = (long)(latitude * VehicleConstant.MIL);
		long lon = (long)(longitude * VehicleConstant.MIL);

		return CycleInfo.builder()
			.intervalAt(intervalAt)
			.gpsStatus(gpsStatus)
			.latitude(lat)
			.longitude(lon)
			.direction(direction)
			.speed(speed)
			.totalDistance(totalDistance)
			.battery(battery)
			.build();
	}
}
