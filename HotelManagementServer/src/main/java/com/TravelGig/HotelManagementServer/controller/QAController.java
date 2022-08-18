package com.TravelGig.HotelManagementServer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.TravelGig.HotelManagementServer.domain.QA;
import com.TravelGig.HotelManagementServer.service.QAService;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class QAController {
    @Autowired
    QAService qaService;

    @GetMapping("/getQAsByHotelAndStatus")
    public List<QA> getQAsByHotelAndStatus(@RequestParam int hotelId, @RequestParam String status){
        return qaService.getQABy(hotelId, status);
    }

    @GetMapping("/getQAsByStatus")
    private List<QA> getQAsByStatus(@RequestParam String status){
        return qaService.getQABy(status);
    }

    @GetMapping("/expiredQAs")
    private List<QA> expiredQAs(@RequestParam String status){
        return qaService.isExpired(status);
    }

}
