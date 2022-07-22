package com.TravelGig.GateServer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HotelViewController {
    
    @GetMapping({"/", "/home", "/index"})
    private String home(){
        return "home";
    }

    // http://localhost:8080/2?searchLocation=new%20york&noRooms=1&noGuests=2&checkInDate=2022-07-22&checkOutDate=2022-07-23
    @RequestMapping("/hotel/{id}")
    private String getHotel(@PathVariable int id, @RequestParam String searchLocation, @RequestParam int noRooms, @RequestParam int noGuests, @RequestParam String checkInDate, @RequestParam String checkOutDate){
        
        return "hotelInf";
    }
}
