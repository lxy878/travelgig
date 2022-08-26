package com.TravelGig.GateServer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.TravelGig.GateServer.domain.ChargeRequest;

@Controller
public class CheckoutController {
    
    @Value("pk_test_51LZfmYI7vGXctebNF4wGJTPeI0rfF6Z4JlTtvritKAXAaxHm9RsAvdKvauGdTsfYXfMidTkngoqGthmThp2qZFb600JrunhnlA")
    private String stripePublicKey;

    @RequestMapping("/checkout")
    public String checkout(Model model) {
        model.addAttribute("amount", 50 * 100); // in cents
        model.addAttribute("stripePublicKey", stripePublicKey);
        model.addAttribute("currency", ChargeRequest.Currency.USD);
        return "checkout";
    }
}
