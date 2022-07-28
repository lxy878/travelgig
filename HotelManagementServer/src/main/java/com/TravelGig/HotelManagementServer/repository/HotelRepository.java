package com.TravelGig.HotelManagementServer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TravelGig.HotelManagementServer.domain.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer>{
    public List<Hotel> findAllByHotelNameContainingOrCityContainingOrStateContainingOrAddressContaining(String name, String city, String state, String address);
    public Hotel findByHotelName(String name);
}
