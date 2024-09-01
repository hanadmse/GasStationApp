package com.application.Application.model;

import java.math.BigDecimal;


public class NozzleReadingDTO {
    private final long nozzleId;
    private final BigDecimal pOpenMeter;
    private final BigDecimal pCloseMeter;
    private final BigDecimal lOpenMeter;
    private final BigDecimal lCloseMeter;
    private final BigDecimal mOpenMeter;
    private final BigDecimal mCloseMeter;

    public NozzleReadingDTO(long nozzleId, BigDecimal pOpenMeter, BigDecimal pCloseMeter, BigDecimal lOpenMeter, BigDecimal lCloseMeter, BigDecimal mOpenMeter, BigDecimal mCloseMeter) {
        this.nozzleId = nozzleId;
        this.pOpenMeter = pOpenMeter;
        this.pCloseMeter = pCloseMeter;
        this.lOpenMeter = lOpenMeter;
        this.lCloseMeter = lCloseMeter;
        this.mOpenMeter = mOpenMeter;
        this.mCloseMeter = mCloseMeter;
    }

    public long getNozzleId() {
        return nozzleId;
    }

    public BigDecimal getpOpenMeter() {
        return pOpenMeter;
    }

    public BigDecimal getlOpenMeter() {
        return lOpenMeter;
    }

    public BigDecimal getpCloseMeter() {
        return pCloseMeter;
    }

    public BigDecimal getlCloseMeter() {
        return lCloseMeter;
    }

    public BigDecimal getmOpenMeter() {
        return mOpenMeter;
    }

    public BigDecimal getmCloseMeter() {
        return mCloseMeter;
    }
}
