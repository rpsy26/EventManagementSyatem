package com.scry.ems.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class UserModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name="user_name")
    @NotNull(message = "User name must required")
    @NotBlank(message = "User name is must not be blank")
    private String userName;

    @Column(name="event_id")
    @NotNull(message = "Event id must required")
    @NotBlank(message = "Event id is must not be blank")
    private int eventID;

    public UserModel(int id, String userName, int eventID) {
        this.id = id;
        this.userName = userName;
        this.eventID = eventID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }
}
