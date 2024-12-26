package org.emulator.infrastructure;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class CtrList {
    private String ctrId;
    private String ctrCd;
    private String ctrVal;
}
