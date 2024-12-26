package org.emulator.infrastructure;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class GeoList {
    private String geoCtrId;
    private String upVal;
    private String geoGrpId;
    private String geoEvtTp;
    private String geoRange;
    private String lat;
    private String lon;
    private String onTime;
    private String offTime;
    private String storeTp;
}
