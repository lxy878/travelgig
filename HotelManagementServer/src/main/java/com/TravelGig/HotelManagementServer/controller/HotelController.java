package com.TravelGig.HotelManagementServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.TravelGig.HotelManagementServer.component.DataComponent;
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

    @Autowired
    DataComponent dataComponent;

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
