package com.TravelGig.GateServer.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.TravelGig.GateServer.domain.BookingDetail;
import com.TravelGig.GateServer.restclient.BookingClient;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class UserViewController {
    
	@Autowired
	BookingClient bookingClient;

    @RequestMapping(value="/login")
	public String login(@RequestParam(required=false) String logout, @RequestParam(required=false) String error, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, Model model) {
		String message = "";
		
		if(error!=null) {
			message="Invalid Credentials"; 
		}
		if(logout!=null) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if(auth!=null) {
				new SecurityContextLogoutHandler().logout(httpServletRequest, httpServletResponse, auth);
			}
			message="Logout";
			return "login";
		}
	
		model.addAttribute("Message", message);
		return "login";
		
	} 

    @RequestMapping(value="/accessDenied")
 	public String accessDenied(Principal principal, Model model) {
 		String message = principal.getName()+", Unauthorised access";
 		model.addAttribute("Message", message);
 		return "accessDenied";

 	}

    @RequestMapping("user/upcomeReservation/{uId}")
    private String getUpcomeReservation(@PathVariable String uId, Model model){
		model.addAttribute("uId", uId);
        return "viewReservation";
    }

	@RequestMapping("/bookingStatus")
	private String bookingStatus(Model model, BookingDetail bd){

		ObjectMapper mapper = new ObjectMapper();
		JsonNode json = mapper.convertValue(bd, JsonNode.class);
		JsonNode respond = bookingClient.postRequest(json, "/bookingRooms");
		
		System.out.println(respond.get("email").asText());
		model.addAttribute("message", "testing");
		// redirect to user/upcomeReservation/{user email}
		return "bookingStatus";
	}
}
