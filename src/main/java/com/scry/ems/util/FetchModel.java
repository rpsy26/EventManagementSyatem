package com.scry.ems.util;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class FetchModel {

    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = " Start date must required")
    @NotBlank(message = "Start date must not be blank")
    private String startDate;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = " End date must required")
    @NotBlank(message = "End date must not be blank")
    private String endDate;

    private String venue;

    public FetchModel(String startDate, String endDate, String venue) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.venue = venue;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }
}
