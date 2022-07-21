package com.TravelGig.HotelManagementServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TravelGig.HotelManagementServer.domain.RoomType;

public interface RoomTypeRepository extends JpaRepository<RoomType, Integer>{
    
}
