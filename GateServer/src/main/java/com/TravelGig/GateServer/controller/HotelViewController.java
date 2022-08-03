package com.TravelGig.GateServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.TravelGig.GateServer.restclient.BookingClient;

@Controller
public class HotelViewController {
    
    @Autowired
    BookingClient bookingClient;

    @GetMapping({"/", "/home", "/index"})
    private String home(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String user = auth.getName();
        if(user.compareTo("anonymousUser")==0){
            user = "";
        }
        bookingClient.getRequest("/completedBooking");    
        model.addAttribute("uId", user);
        return "home";
    }
}
