package com.TravelGig.GateServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.TravelGig.GateServer.restclient.HotelManagementClient;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
public class HotelRestController {
    
    @Autowired
    HotelManagementClient hotelManagementClient;
    
    @PostMapping("/searchHotels")
    private ResponseEntity<JsonNode> searchHotels(@RequestBody JsonNode json){
        JsonNode respond = hotelManagementClient.getRequest("/getHotels/"+json.get("searchLocation").asText());
        return new ResponseEntity<>(respond, HttpStatus.OK);
    }

    @GetMapping("/getRoomTypes")
    private ResponseEntity<JsonNode> getRoomTypes(){
        JsonNode respond = hotelManagementClient.getRequest("/getRoomTypes");
        return new ResponseEntity<>(respond, HttpStatus.OK);
    }

    @PostMapping("/getRooms")
    private ResponseEntity<JsonNode> getRooms(@RequestBody JsonNode json){
        JsonNode respond = hotelManagementClient.getRequest("/getRooms/"+json.get("hotelId").asInt());
        return new ResponseEntity<>(respond, HttpStatus.OK);
    }
}
