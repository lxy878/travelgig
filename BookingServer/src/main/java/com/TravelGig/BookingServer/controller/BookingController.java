package com.TravelGig.BookingServer.controller;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class BookingController {
    
    @PostMapping(value="/bookingRooms")
    public String postMethodName(@RequestBody JsonNode json) {
        System.out.println("called");
        return "";
    }
    
}
