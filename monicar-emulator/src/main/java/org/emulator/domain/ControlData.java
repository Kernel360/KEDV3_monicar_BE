package org.emulator.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class ControlData {
    private final String controlId;
    private final String controlCode;
    private final String cycleInfoTransmitTerm;
}
