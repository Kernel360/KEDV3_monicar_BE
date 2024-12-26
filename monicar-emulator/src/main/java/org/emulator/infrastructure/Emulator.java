package org.emulator.infrastructure;


import lombok.Getter;
import lombok.Setter;

@Getter
public class Emulator {
    private String mdn;
    private final String tid = EmulatorConstant.TID;
    private final String mid = EmulatorConstant.MID;
    private final String pv = EmulatorConstant.PV;
    private final String did = EmulatorConstant.DID;
    @Setter
    private String onGPS;
    @Setter
    private String offGPS;
    @Setter
    private String sum;
    private CtrList ctrList;
    private GeoList geoList;

    public void updateCtrList(CtrList ctrList) {
        this.ctrList = CtrList.builder()
                .ctrId(ctrList.getCtrId())
                .ctrCd(ctrList.getCtrCd())
                .ctrVal(ctrList.getCtrVal())
                .build();
    }

    public void updateGeoList(GeoList geoList) {
        this.geoList = GeoList.builder()
                .geoCtrId(geoList.getGeoCtrId())
                .upVal(geoList.getUpVal())
                .geoGrpId(geoList.getGeoGrpId())
                .geoEvtTp(geoList.getGeoEvtTp())
                .geoRange(geoList.getGeoRange())
                .lat(geoList.getLat())
                .lon(geoList.getLon())
                .onTime(geoList.getOnTime())
                .offTime(geoList.getOffTime())
                .storeTp(geoList.getStoreTp())
                .build();
    }
}