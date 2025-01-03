package org.emulator.device;

public final class VehicleConstant {
	public static final String VEHICLE_NUM = "01234567890";
	public static final String TERMINAL_ID = "A001";
	public static final String MANUFACTURER_ID = "6";
	public static final String PACKET_VERSION = "5";
	public static final String DEVICE_ID = "1";
	public static final int BATTERY = 100;
	public static final long MIL = 1000_000;

	private VehicleConstant() {
		throw new AssertionError();
	}
}
