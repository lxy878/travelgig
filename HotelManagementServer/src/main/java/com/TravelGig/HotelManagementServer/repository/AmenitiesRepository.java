package com.TravelGig.HotelManagementServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TravelGig.HotelManagementServer.domain.Amenities;

public interface AmenitiesRepository extends JpaRepository<Amenities, Integer>{
    public Amenities findByName(String name);
    
}
