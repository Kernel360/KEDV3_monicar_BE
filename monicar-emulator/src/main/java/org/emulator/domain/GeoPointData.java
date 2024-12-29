package org.emulator.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class GeoPointData {
    private String geoPointId;
    private String updateStatus;
    private String geoGroupId;
    private String geoAlertType;
    private String geoRange;
    private String latitude;
    private String longitude;
    private String geoPointStartTime;
    private String geoPointStopTime;
    private String saveType;
}
