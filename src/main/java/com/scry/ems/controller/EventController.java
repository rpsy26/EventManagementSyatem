package com.scry.ems.controller;

import com.scry.ems.model.EventModel;
import com.scry.ems.repository.EventRepository;
import com.scry.ems.util.FetchModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/event")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @RequestMapping(method = RequestMethod.POST, value = "/create")
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
    @RequestMapping(method = RequestMethod.GET, value = "/all")
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
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/fetch", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity fetchEvents(@RequestBody FetchModel request) {
        if (request.getStartDate() != null && request.getEndDate() != null
        && !request.getStartDate().isEmpty() && !request.getEndDate().isEmpty()) {
            List<EventModel> eventModelList = eventRepository.fetchVenuesBasedOnDates(request.getStartDate(), request.getEndDate());
            Map<LocalDate, List<EventModel>> map = eventModelList.stream().filter(venue -> venue.getVenue().equals(request.getVenue())).collect(Collectors.groupingBy(EventModel::getStartDate, Collectors.toList()));
            if (map.size() > 0) {
                return new ResponseEntity(map, HttpStatus.OK);
            } else {
                return new ResponseEntity("No events found", HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity("Provide valid Start and End date", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
