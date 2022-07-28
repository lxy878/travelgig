package com.TravelGig.HotelManagementServer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TravelGig.HotelManagementServer.domain.RoomType;
import com.TravelGig.HotelManagementServer.repository.RoomTypeRepository;

@Service
public class RoomTypeService {
    
    @Autowired
    RoomTypeRepository roomTypeRepository;

    public RoomType findByName(String name){
        return roomTypeRepository.findByName(name);
    }

    public List<RoomType> findAll(){
        return roomTypeRepository.findAll();
    }
}
