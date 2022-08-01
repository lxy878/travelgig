package com.TravelGig.BookingServer.controller;

import org.springframework.web.bind.annotation.RestController;

import com.TravelGig.BookingServer.domain.BookingDetail;
import com.TravelGig.BookingServer.service.BookingDetailService;

import org.springframework.beans.factory.annotation.Autowired;
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
    
}
