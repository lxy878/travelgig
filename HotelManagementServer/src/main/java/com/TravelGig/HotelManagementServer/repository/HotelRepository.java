package com.TravelGig.HotelManagementServer.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.TravelGig.HotelManagementServer.domain.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer>{
    public Hotel findByHotelName(String name);
    @Query(value="select * from hotels where hotel_name like ?1% or city like ?1% or state like ?1% or address like ?1%", nativeQuery = true)
    public List<Hotel> findAllByLoation(String location);
    @Query(value="select * from hotels where (hotel_name like ?1% or city like ?1% or state like ?1% or address like ?1%) and (average_price <= ?2 or star_rating in ?3)", nativeQuery = true)
    public List<Hotel> findAllByOthers(String location, double price, Collection<Integer> stars);
    
}
