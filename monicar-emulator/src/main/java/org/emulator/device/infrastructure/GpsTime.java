package org.emulator.device.infrastructure;

import org.emulator.pipe.Gps;

import java.time.LocalDateTime;

public record GpsTime(
	Gps location,
	LocalDateTime intervalAt
) {
	public static GpsTime create(Gps location) {
		return new GpsTime(location, LocalDateTime.now());
	}
}
