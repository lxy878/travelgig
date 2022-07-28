package com.TravelGig.GateServer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HotelViewController {
    
    @GetMapping({"/", "/home", "/index"})
    private String home(){
        return "home";
    }

    // http://localhost:8080/2?searchLocation=new%20york&noRooms=1&noGuests=2&checkInDate=2022-07-22&checkOutDate=2022-07-23
    @RequestMapping("/hotel")
    private String getHotel(@RequestParam String hotelId, 
        @RequestParam String searchLocation, 
        @RequestParam String noRooms, 
        @RequestParam String noGuests, 
        @RequestParam String checkInDate, 
        @RequestParam String checkOutDate, Model model){
        model.addAttribute("hotelId", Integer.parseInt(hotelId));
        model.addAttribute("searchLocation", searchLocation);
        model.addAttribute("noRooms", Integer.parseInt(noRooms));
        model.addAttribute("noGuests", Integer.parseInt(noGuests));
        model.addAttribute("checkInDate", checkInDate);
        model.addAttribute("checkOutDate", checkOutDate);
        return "hotelInf";
    }
}
