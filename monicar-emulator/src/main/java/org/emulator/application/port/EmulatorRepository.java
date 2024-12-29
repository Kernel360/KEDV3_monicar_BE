package org.emulator.application.port;

import org.emulator.domain.VehicleGlobalData;

/**
 * 차량 정보 저장 역할
 */
public interface EmulatorRepository {

    VehicleGlobalData getVehicleInfo();

    VehicleGlobalData save(VehicleGlobalData vehicleGlobalData);
}
