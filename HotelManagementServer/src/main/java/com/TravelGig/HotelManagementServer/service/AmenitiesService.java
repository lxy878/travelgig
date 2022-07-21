package com.TravelGig.HotelManagementServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TravelGig.HotelManagementServer.domain.Amenities;
import com.TravelGig.HotelManagementServer.repository.AmenitiesRepository;

@Service
public class AmenitiesService {
    
    @Autowired
    AmenitiesRepository amenitiesRepository;
    
    public Amenities findByName(String name){
        return amenitiesRepository.findByName(name);
    }
}
