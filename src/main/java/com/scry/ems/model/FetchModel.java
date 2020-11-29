package com.scry.ems.model;

public class FetchModel {

    private String startDate;
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
