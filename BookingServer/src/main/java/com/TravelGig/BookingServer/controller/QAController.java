package com.TravelGig.BookingServer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.TravelGig.BookingServer.domain.QA;
import com.TravelGig.BookingServer.service.QAService;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class QAController {
    @Autowired
    QAService qaService;

    @PostMapping("/createQA")
    private QA createQA(@RequestBody QA qa){
        return qaService.createQA(qa);
    }

    @GetMapping("/getQAsByHotelAndStatus")
    public List<QA> getQAsByHotelAndStatus(@RequestParam int hotelId, @RequestParam String status){
        return qaService.getQABy(hotelId, status);
    }

    @GetMapping("/getQAsByStatus")
    public List<QA> getQAsByStatus(@RequestParam String status){
        return qaService.getQABy(status);
    }

}
