package com.TravelGig.BookingServer.controller;

import org.springframework.web.bind.annotation.RestController;

import com.TravelGig.BookingServer.component.CreateFile;
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

    @Autowired
    CreateFile createFile;
    
    @PostMapping(value="/bookingRooms")
    public BookingDetail postMethodName(@RequestBody BookingDetail bd) {
        bd = bookingDetailService.save(bd);
        String message = createFile.messageForm(bd);
        String pdfPath = createFile.PDF(message, "/pdf/", "Reservation_"+bd.getId()+".pdf");
        emailService.sentEmail(bd.getEmail(), bd.getId(), "Hotel Reservation Comfirmation", message, pdfPath);
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
}
