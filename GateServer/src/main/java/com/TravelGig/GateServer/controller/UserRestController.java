package com.TravelGig.GateServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.TravelGig.GateServer.domain.User;
import com.TravelGig.GateServer.restclient.BookingClient;
import com.TravelGig.GateServer.service.UserService;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
public class UserRestController {
    @Autowired
    UserService userService;

    @Autowired
    BookingClient bookingClient;

    @PostMapping("/saveUser")
    private ResponseEntity<String> saveUser(@RequestBody User user){
        User u = userService.createUser(user);
        System.out.println(u.toString());
        return new ResponseEntity<>("Account is created", HttpStatus.OK);
    }

    @PostMapping("/api/bookingrooms")
    private ResponseEntity<JsonNode> saveUser(@RequestBody JsonNode json){
        JsonNode respond = bookingClient.postRequest(json, "/bookingRooms");
        return new ResponseEntity<>(respond, HttpStatus.OK);
    }
}
