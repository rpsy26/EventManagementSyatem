package com.scry.ems.controller;

import com.scry.ems.model.EventModel;
import com.scry.ems.model.UserModel;
import com.scry.ems.repository.EventRepository;
import com.scry.ems.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    EventRepository eventRepository;

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public ResponseEntity<String> registerUser(@RequestBody UserModel user) {
        try {
            Optional<EventModel> eventModel = eventRepository.findById(user.getEventID());
            if (eventModel.isPresent()) {
                int numuser = eventModel.get().getNumUsers();
                eventModel.get().setNumUsers(numuser + 1);
                eventRepository.save(eventModel.get());
                userRepository.save(user);
                return new ResponseEntity("Successfully added user:  " + user.getUserName(), HttpStatus.OK);
            } else {
                return new ResponseEntity("No such event", HttpStatus.INTERNAL_SERVER_ERROR);

            }
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
