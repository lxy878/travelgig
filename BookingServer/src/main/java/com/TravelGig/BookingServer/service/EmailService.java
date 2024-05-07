package com.TravelGig.BookingServer.service;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    
    @Autowired
    JavaMailSender javaMailSender;

    public void sentEmail(String email, String title, String message, String pdfPath){

        MimeMessagePreparator msgPreparator = new MimeMessagePreparator() {

            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
                helper.setTo(new InternetAddress(email));
                helper.setSubject(title);
                helper.setText(message);
                if(pdfPath == null){
                    helper.addAttachment("Reservation_Information.pdf", new ClassPathResource(pdfPath));
                }     
            }
            
        };

        try{
            javaMailSender.send(msgPreparator);
        }catch(MailException ex){
            ex.printStackTrace();
            System.err.println(ex.getMessage());
        }
        
    }
    
}
