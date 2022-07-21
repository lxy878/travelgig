package com.TravelGig.HotelManagementServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TravelGig.HotelManagementServer.domain.HotelRoom;

public interface HotelRoomRepository extends JpaRepository<HotelRoom, Integer>{
    
}
