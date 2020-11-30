package com.scry.ems.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotBlank;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "event")
public class EventModel {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column(name="event_name")
    @NotNull(message = "Event name must required")
    @NotBlank(message = "Event name must not be blank")
    private String eventName;

    @Column(name="speaker_name")
    @NotNull(message = " Event speaker name must required")
    @NotBlank(message = "Event speaker name must not be blank")
    private String speaker;

    @Column(name="venue_name")
    @NotNull(message = "Event venue name must required")
    @NotBlank(message = "Event venue must not be blank")
    private String venue;

    @Column(name="num_users")
    private int numUsers;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "date")
    @NotNull(message = "Event date must required")
    private LocalDate startDate;

    public EventModel() {
    }

    public EventModel(String eventName, String speaker, String venue, LocalDate startDate) {
        this.eventName = eventName;
        this.speaker = speaker;
        this.venue = venue;
        this.startDate = startDate;
        this.numUsers = 0;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getNumUsers() {
        return numUsers;
    }

    public void setNumUsers(int numUsers) {
        this.numUsers = numUsers;
    }

    @Override
    public String toString() {
        return "EventModel{" +
                "id=" + id +
                ", eventName='" + eventName + '\'' +
                ", speaker='" + speaker + '\'' +
                ", venue='" + venue + '\'' +
                ", startDate=" + startDate +
                '}';
    }
}
