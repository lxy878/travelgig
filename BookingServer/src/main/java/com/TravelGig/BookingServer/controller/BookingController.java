package com.TravelGig.BookingServer.controller;

import org.springframework.web.bind.annotation.RestController;

import com.TravelGig.BookingServer.domain.BookingDetail;
import com.TravelGig.BookingServer.service.BookingDetailService;
import com.TravelGig.BookingServer.service.EmailService;
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

    @Autowired
    EmailService emailService;
    
    @PostMapping(value="/bookingRooms")
    public BookingDetail postMethodName(@RequestBody BookingDetail bd) {
        bd = bookingDetailService.save(bd);
        emailService.sentEmail(bd.getEmail(), bd.getId(), "Hotel Reservation Comfirmation", messageForm(bd));
        return bd;
    }

    @PostMapping(value = "/getBookingDetails")
    public List<BookingDetail> getBookingDetails(@RequestBody JsonNode json){
        return bookingDetailService.findBookingDetailsBy(json.get("uId").asText(), json.get("status").asText());
    }

    @GetMapping(value = "/cancelBookingDetails/{bId}")
    public BookingDetail cancelBookingDetails(@PathVariable int bId){
        return bookingDetailService.cancelBooking(bId);
    }

    @GetMapping(value = "/completedBooking")
    public List<BookingDetail> completedBooking(){
        return bookingDetailService.completedBooking();
    }

    private String messageForm(BookingDetail bd){
        StringBuilder message = new StringBuilder();
        message.append("\nBooking Id: "+bd.getId());
        message.append("\nHotel Name: "+bd.getHotelName());
        message.append("\nCheck In: "+bd.getCheckInDate());
        message.append("\nCheck Out: "+bd.getCheckOutDate());
        message.append("\nGuest No. : "+bd.getNoGuests());
        message.append("\nRoom No. : "+bd.getNoRooms());
        message.append("\nRoom Type : "+bd.getRoomType());
        message.append("\nCustomer Name : "+bd.getUserName());
        return message.toString();
    }
}
