package com.TravelGig.GateServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GateServerApplication {

	public static void main(String[] args) {		
		SpringApplication.run(GateServerApplication.class, args);
		// String currentDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		// System.out.println(currentDate);
        
		// BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        //  String pw = encoder.encode("a");
        //  System.out.println(pw);
	}

}
