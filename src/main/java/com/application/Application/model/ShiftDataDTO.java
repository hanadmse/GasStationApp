package com.application.Application.model;

import java.util.List;

public class ShiftDataDTO {
    private final Long shiftId;
    private final List<NozzleReadingDTO> nozzleReadingData;
    private final List<TankReadingDTO> tankReadingData;
    private final List<AccWithdrawalsDTO> accountWithdrawalData;

    public ShiftDataDTO(Long shiftId, List<NozzleReadingDTO> nozzleReadingData, List<TankReadingDTO> tankReadingData, List<AccWithdrawalsDTO> accountWithdrawalData) {
        this.shiftId = shiftId;
        this.nozzleReadingData = nozzleReadingData;
        this.tankReadingData = tankReadingData;
        this.accountWithdrawalData = accountWithdrawalData;
    }

    public Long getShiftId() {
        return shiftId;
    }

    public List<NozzleReadingDTO> getNozzleReadingData() {
        return nozzleReadingData;
    }

    public List<TankReadingDTO> getTankReadingData() {
        return tankReadingData;
    }

    public List<AccWithdrawalsDTO> getAccountWithdrawalData() {
        return accountWithdrawalData;
    }
}
