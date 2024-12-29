package org.emulator.domain;

public final class EmulatorInfo {
    public static final String TERMINAL_ID = "A001";
    public static final String MANUFACTURER_ID = "6";
    public static final String PACKET_VERSION = "5";
    public static final String DEVICE_ID = "1";
    public static final String CONTROL_CODE = "05";

    private EmulatorInfo() {
        throw new AssertionError();
    }
}
