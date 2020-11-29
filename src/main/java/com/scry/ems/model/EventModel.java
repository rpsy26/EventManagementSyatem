package com.scry.ems.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "event")
public class EventModel {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String eventName;
    private String speaker;
    private String venue;
    private String startDate;

    public EventModel() {
    }

    public EventModel(String eventName, String speaker, String venue, String startDate) {
        this.eventName = eventName;
        this.speaker = speaker;
        this.venue = venue;
        this.startDate = startDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }


}
