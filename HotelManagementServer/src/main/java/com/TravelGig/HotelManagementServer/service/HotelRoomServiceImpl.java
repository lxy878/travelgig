package com.TravelGig.HotelManagementServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TravelGig.HotelManagementServer.domain.Hotel;
import com.TravelGig.HotelManagementServer.domain.HotelRoom;
import com.TravelGig.HotelManagementServer.repository.HotelRoomRepository;

@Service
public class HotelRoomServiceImpl implements HotelRoomService{
    
    @Autowired
    HotelRoomRepository hotelRoomRepository;

    @Autowired
    HotelService hotelService;

    @Autowired
    AmenitiesService amenitiesService;

    @Autowired
    RoomTypeService roomTypeService;

    @Override
    public HotelRoom save(HotelRoom hr){
        Hotel h = hotelService.findByName(hr.getHotelName());
        h.getHotelRooms().add(hr);
        for(String a : hr.getHotelRoomAmenityNames()){
            hr.getAmenities().add(amenitiesService.findByName(a));
        }
        hr.setType(roomTypeService.findByName(hr.getRoomType()));
        return hotelRoomRepository.save(hr);
    }

}
