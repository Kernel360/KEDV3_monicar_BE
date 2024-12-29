package org.emulator.infrastructure.repository;

import org.emulator.application.port.EmulatorRepository;
import org.emulator.domain.VehicleGlobalData;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryEmulatorRepository implements EmulatorRepository {
    private VehicleGlobalData vehicleGlobalData = new VehicleGlobalData();

    @Override
    public VehicleGlobalData getVehicleInfo() {
        return vehicleGlobalData;
    }

    @Override
    public VehicleGlobalData save(VehicleGlobalData vehicleGlobalData) {
        this.vehicleGlobalData = vehicleGlobalData;
        return this.vehicleGlobalData;
    }
}
