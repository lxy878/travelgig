package com.TravelGig.HotelManagementServer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.TravelGig.HotelManagementServer.domain.Hotel;
import com.TravelGig.HotelManagementServer.domain.HotelRoom;
import com.TravelGig.HotelManagementServer.service.HotelRoomService;
import com.TravelGig.HotelManagementServer.service.HotelService;


@RestController
public class HotelController {
    @Autowired
    HotelService hotelService;

    @Autowired
    HotelRoomService hotelRoomService;

    @GetMapping("/getHotels/{searchInput}")
    private List<Hotel> getHotels(@PathVariable String searchInput){
        return hotelService.getHotelsByWord(searchInput);
    }
    
    @PostMapping("/saveHotel")
    private Hotel addHotel(@RequestBody Hotel hotel){
        return hotelService.save(hotel);
    }

    @PostMapping("/saveRoom")
    public HotelRoom addRoom(@RequestBody HotelRoom room) {
        hotelRoomService.save(room);
        return null;
    }
    
}
