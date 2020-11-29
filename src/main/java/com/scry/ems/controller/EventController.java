package com.scry.ems.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.scry.ems.model.EventModel;
import com.scry.ems.model.FetchModel;
import com.scry.ems.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @RequestMapping(method = RequestMethod.POST, value = "/event")
    public ResponseEntity<String> createEvent(@RequestBody EventModel event) {
        try {
            eventRepository.save(event);
            return new ResponseEntity("Successfully added event " + event.getEventName(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Method use for get all movies from database
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/event")
    public ResponseEntity getAllEvents() {
        List<EventModel> events = eventRepository.findAll();
        if (events.size() > 0) {
            return new ResponseEntity(events, HttpStatus.OK);
        } else {
            return new ResponseEntity("No events found", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Method use for get event between two dates from database
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/fetch", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity fetchEvents(@RequestBody FetchModel request) {
        List<EventModel> events = eventRepository.findAll().stream().
                filter(city -> city.getVenue().equals(request.getVenue())).
                collect(Collectors.toList());
        HashMap<String, List<EventModel>> map = new HashMap();
        Gson gson = new Gson();
        map.put(events.get(0).getStartDate(), events);
        return new ResponseEntity(gson.toJson(map), HttpStatus.OK);
    }

}
