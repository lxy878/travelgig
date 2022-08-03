package com.TravelGig.BookingServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    
    @Autowired
    JavaMailSender javaMailSender;

    public void sentEmail(String email, String title, String message){
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(email);
        msg.setSubject(title);
        msg.setText(message);
        javaMailSender.send(msg);
    }
}
