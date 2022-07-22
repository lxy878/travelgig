package com.TravelGig.HotelManagementServer.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TravelGig.HotelManagementServer.domain.Amenities;
import com.TravelGig.HotelManagementServer.domain.Hotel;
import com.TravelGig.HotelManagementServer.repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService{

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    AmenitiesService amenitiesService;

    @Override
    public Hotel save(Hotel hotel) {
        Set<String> amenityNames = hotel.getHotelAmenityNames();
        for(String amenityName : amenityNames){
            Amenities a = amenitiesService.findByName(amenityName);
            if(a==null){
                a = new Amenities();
                a.setName(amenityName);
            }
            hotel.getAmenities().add(a);
        }
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getHotelsByWord(String word){
        return hotelRepository.findAllByHotelNameContainingOrCityContainingOrStateContainingOrAddressContaining(word, word, word, word);
    }
    
}