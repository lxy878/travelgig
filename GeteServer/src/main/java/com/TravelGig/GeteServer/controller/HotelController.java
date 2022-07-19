package com.TravelGig.GeteServer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HotelController {
    
    @GetMapping({"/", "/home", "/index"})
    private String home(){
        return "home";
    }
}
