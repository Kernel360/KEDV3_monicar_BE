package org.emulator.application;

import org.emulator.infrastructure.CtrList;
import org.emulator.infrastructure.GeoList;

public interface EmulatorRepository {
    void updateOnGPS(String onGPS);
    void updateOffGPS(String offGPS);
    void updateSum(String sum);
    void updateCtrList(CtrList ctrList);
    void updateGeoList(GeoList geoList);
}
