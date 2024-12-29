package org.emulator.infrastructure.messaging.event;

import org.emulator.domain.EmulatorInfo;

public class VehicleEvent {
    private final String terminalId = EmulatorInfo.TERMINAL_ID;
    private final String manufacturerId = EmulatorInfo.MANUFACTURER_ID;
    private final String packetVersion = EmulatorInfo.PACKET_VERSION;
    private final String deviceId = EmulatorInfo.DEVICE_ID;
    private String carNumber;
    private String vehicleStartTime;
    private String vehicleStopTime;
    private String gpsStatus;
    private String latitude;
    private String longitude;
    private String direction;
    private String speed;
    private String totalDistance;
}
