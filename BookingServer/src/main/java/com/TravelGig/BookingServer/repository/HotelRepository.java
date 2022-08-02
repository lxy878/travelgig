package com.TravelGig.BookingServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TravelGig.BookingServer.domain.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer>{
}
