package com.TravelGig.GateServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.TravelGig.GateServer.restclient.BookingClient;
import com.TravelGig.GateServer.restclient.HotelManagementClient;

@Controller
public class HotelViewController {
    
    @Autowired
    BookingClient bookingClient;

    @Autowired
    HotelManagementClient hotelManagementClient;

    @GetMapping({"/", "/home", "/index"})
    private String home(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String user = "";
        if(auth.getName().compareTo("anonymousUser")!=0){
            user = auth.getName();
        }
        // check completed reservations
        bookingClient.getRequest("/completedBooking");    
        // check expried qas
        hotelManagementClient.getRequest("/expiredQAs?status=pending");
        model.addAttribute("uId", user);

        return "home";
    }

}
