package com.TravelGig.HotelManagementServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TravelGig.HotelManagementServer.domain.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer>{
    
}
