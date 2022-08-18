package com.TravelGig.GateServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/getHotel/{hotelId}")
    private ResponseEntity<JsonNode> getHotel(@PathVariable int hotelId){
        JsonNode respond = hotelManagementClient.getRequest("/getHotel/"+hotelId);
        return new ResponseEntity<>(respond, HttpStatus.OK);
    }

    @GetMapping("/getComments/{hotelId}")
    private ResponseEntity<JsonNode> getComments(@PathVariable int hotelId){
        JsonNode respond = hotelManagementClient.getRequest("/getComments/"+hotelId);
        return new ResponseEntity<>(respond, HttpStatus.OK);
    }

    @PostMapping("/searchHotelsByOther")
    private ResponseEntity<JsonNode> searchHotelsByOther(@RequestBody JsonNode json){
        JsonNode respond = hotelManagementClient.postRequest("/searchHotelsByOthers", json);
        return new ResponseEntity<>(respond, HttpStatus.OK);
    }
    
    @GetMapping("/getCommonQuestions")
    private ResponseEntity<JsonNode> getCommonQuestions(@RequestParam int hotelId, @RequestParam String status){
        JsonNode respond = hotelManagementClient.getRequest("/getQAsByHotelAndStatus?hotelId="+hotelId+"&status="+status);
        return new ResponseEntity<>(respond, HttpStatus.OK);
    }

    @GetMapping("/getQAsByStatus")
    private ResponseEntity<JsonNode> getQAsByStatus(@RequestParam String status){
        JsonNode respond = hotelManagementClient.getRequest("/getQAsByStatus?status="+status);
        return new ResponseEntity<>(respond, HttpStatus.OK);
    }
}
