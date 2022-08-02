package com.TravelGig.BookingServer.controller;

import org.springframework.web.bind.annotation.RestController;

import com.TravelGig.BookingServer.domain.BookingDetail;
import com.TravelGig.BookingServer.service.BookingDetailService;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class BookingController {

    @Autowired
    BookingDetailService bookingDetailService;
    
    @PostMapping(value="/bookingRooms")
    public BookingDetail postMethodName(@RequestBody BookingDetail bd) {
        
        return bookingDetailService.save(bd);
    }

    @PostMapping(value = "/getBookingDetails")
    public List<BookingDetail> getBookingDetails(@RequestBody JsonNode json){
        return bookingDetailService.findBookingDetailsBy(json.get("uId").asText(), json.get("status").asText());
    }

    @GetMapping(value = "/cancelBookingDetails/{bId}")
    public BookingDetail cancelBookingDetails(@PathVariable int bId){
        return bookingDetailService.cancelBooking(bId);
    }
}
