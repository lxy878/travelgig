package com.TravelGig.BookingServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TravelGig.BookingServer.domain.User;
import com.TravelGig.BookingServer.repository.UserResponsitory;

@Service
public class UserService {
    
    @Autowired
    UserResponsitory userResponsitory;

    public User getUser(String email){
        return userResponsitory.findByEmail(email);
    }
}
