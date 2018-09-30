package com.supercorp.vacplan;

public class VacationInput {
    private final long userId;
    private final String startDate;
    private final String endDate;

    public long getUserId() {
        return userId;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public VacationInput(long userId, String startDate, String endDate) {
        this.userId = userId;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
