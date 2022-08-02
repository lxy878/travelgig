package com.TravelGig.GateServer.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HotelViewController {
    
    @GetMapping({"/", "/home", "/index"})
    private String home(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String user = auth.getName();
        if(user.compareTo("anonymousUser")==0){
            user = "";
        }
        model.addAttribute("uId", user);
        return "home";
    }
}
