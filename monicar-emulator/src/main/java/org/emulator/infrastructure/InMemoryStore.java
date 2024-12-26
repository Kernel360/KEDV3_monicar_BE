package org.emulator.infrastructure;

import org.emulator.application.EmulatorRepository;

public class InMemoryStore implements EmulatorRepository {
    static Emulator emulator;

    @Override
    public void updateOnGPS(String onGPS) {
        emulator.setOnGPS(onGPS);
    }

    @Override
    public void updateOffGPS(String offGPS) {
        emulator.setOffGPS(offGPS);
    }

    @Override
    public void updateSum(String sum) {
        emulator.setSum(sum);
    }

    @Override
    public void updateCtrList(CtrList ctrList) {
        emulator.updateCtrList(ctrList);
    }

    @Override
    public void updateGeoList(GeoList geoList) {
        emulator.updateGeoList(geoList);
    }
}
