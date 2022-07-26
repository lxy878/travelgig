package com.TravelGig.GateServer.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        return u != null ? new ResponseEntity<>("Account is created", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
    }

    @PostMapping("/user/getBookingDetails")
    private ResponseEntity<JsonNode> getBookingDetails(@RequestBody JsonNode json){
        JsonNode respond = bookingClient.postRequest(json, "/getBookingDetails");
        return new ResponseEntity<>(respond, HttpStatus.OK);
    }

    @GetMapping("/user/cancelBooking/{bId}")
    private ResponseEntity<JsonNode> getBookingDetails(@PathVariable int bId){
        JsonNode respond = bookingClient.getRequest("/cancelBookingDetails/"+bId);
        return new ResponseEntity<>(respond, HttpStatus.OK);
    }

    @PostMapping("/registerUser")
    private Map<String, String> registerUser(@RequestBody User user){
        
        User u = userService.createUser(user);
        Map<String, String> map = new HashMap<>();
        map.put("message", "Account created");
        
        if(u == null){
            map.put("message", "Account failed");
        }
        
        return map;
    }

    @PostMapping("/user/makeComment")
    private ResponseEntity<JsonNode> makeComment(@RequestBody JsonNode json){
        JsonNode respond = bookingClient.postRequest(json, "/saveComment");
        return new ResponseEntity<>(respond, HttpStatus.OK);
    }

    @PostMapping("/user/sumbitQuestion")
    private ResponseEntity<JsonNode> sumbitQuestion(@RequestBody JsonNode json){
        JsonNode respond = bookingClient.postRequest(json, "/createQA");
        return new ResponseEntity<>(respond, HttpStatus.OK);
    }

    @PostMapping("/user/updateQA")
    private ResponseEntity<JsonNode> updateQA(@RequestBody JsonNode json){
        JsonNode respond = bookingClient.postRequest(json, "/updateQA");
        return new ResponseEntity<>(respond, HttpStatus.OK);
    }
}
