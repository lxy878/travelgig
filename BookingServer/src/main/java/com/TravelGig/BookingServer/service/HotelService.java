package com.TravelGig.BookingServer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TravelGig.BookingServer.domain.Hotel;
import com.TravelGig.BookingServer.repository.HotelRepository;

@Service
public class HotelService {
    @Autowired
    HotelRepository hotelRepository;

    public Hotel getHotel(int id){
        Optional<Hotel> h = hotelRepository.findById(id);
        if(!h.isPresent()){
            return null;
        }
        return h.get();
    }
    public Hotel geHotel(String name){
        return hotelRepository.findByHotelName(name);
    }

    public Hotel update(Hotel hotel){
        return hotelRepository.save(hotel);
    }
}
