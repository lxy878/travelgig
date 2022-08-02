package com.TravelGig.BookingServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TravelGig.BookingServer.domain.User;

public interface UserResponsitory extends JpaRepository<User, String>{
    public User findByEmail(String email);
}
