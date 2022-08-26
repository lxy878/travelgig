package com.TravelGig.GateServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;

import com.TravelGig.GateServer.domain.BookingDetail;
import com.TravelGig.GateServer.domain.ChargeRequest;
import com.TravelGig.GateServer.domain.ChargeRequest.Currency;
import com.TravelGig.GateServer.restclient.BookingClient;
import com.TravelGig.GateServer.service.StripeService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

@Controller
public class ChargeController {

    @Autowired
    private StripeService paymentsService;

    @Autowired
    private BookingClient bookingClient;

    @PostMapping("/charge")
    public String charge(ChargeRequest chargeRequest, Model model)
      throws StripeException {
        chargeRequest.setDescription("Example charge");
        chargeRequest.setCurrency(Currency.USD);
        Charge charge = paymentsService.charge(chargeRequest);
        model.addAttribute("id", charge.getId());
        model.addAttribute("status", charge.getStatus());
        model.addAttribute("chargeId", charge.getId());
        model.addAttribute("balance_transaction", charge.getBalanceTransaction());
        model.addAttribute("message", "loaded");
        // booking
        BookingDetail bd = chargeRequest.getBd();
        ObjectMapper mapper = new ObjectMapper();
		JsonNode json = mapper.convertValue(bd, JsonNode.class);
		JsonNode respond = bookingClient.postRequest(json, "/bookingRooms");
		String email = respond.get("email").asText();
        
        return "redirect:user/upcomeReservation/"+email;
    }

    @ExceptionHandler(StripeException.class)
    public String handleError(Model model, StripeException ex) {
        model.addAttribute("error", ex.getMessage());
        return "result";
    }
}