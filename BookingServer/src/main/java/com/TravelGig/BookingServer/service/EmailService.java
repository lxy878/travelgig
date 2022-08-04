package com.TravelGig.BookingServer.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class EmailService {
    
    @Autowired
    JavaMailSender javaMailSender;

    public void sentEmail(String email, int bdId, String title, String message){
        
        String filePath = createPDF(message, "pdf/", "Reservation_"+bdId+".pdf");
        System.out.println(filePath);

        MimeMessage msg = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(msg, true);
            helper.setTo(email);
            helper.setSubject(title);
            helper.setText(message);
            
            FileSystemResource file = new FileSystemResource(new File(filePath));
            helper.addAttachment("Reservation_Information.pdf", file);
            javaMailSender.send(msg);
        } catch (MessagingException e) {
            
            e.printStackTrace();
        }
        
    }
    private String createPDF(String message,String path, String fileName){

		try {
            Document doc = new Document();
			PdfWriter.getInstance(doc, new FileOutputStream(path+fileName));
			doc.open();
			doc.add(new Paragraph(message));
			doc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}

        return path+fileName;
    }
}
