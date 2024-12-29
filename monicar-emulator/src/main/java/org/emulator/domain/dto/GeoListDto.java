package org.emulator.domain.dto;

public record GeoListDto (
    String geoCtrId,
    String upVal,
    String geoGrpId,
    String geoEvtTp,
    String geoRange,
    String lat,
    String lon,
    String onTime,
    String offTime,
    String storeTp
) {}
