package com.TravelGig.BookingServer.service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    
    @Autowired
    JavaMailSender javaMailSender;

    public void sentEmail(String email, int bdId, String title, String message, String pdfPath){

        MimeMessage msg = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(msg, true);
            helper.setTo(email);
            helper.setSubject(title);
            helper.setText(message);
            if(pdfPath != null){
                FileSystemResource file = new FileSystemResource(new File(pdfPath));
                helper.addAttachment("Reservation_Information.pdf", file);
            }
        } catch (MessagingException e) {
            e.printStackTrace();
        } finally{
            javaMailSender.send(msg);
        }
        
    }
    
}
