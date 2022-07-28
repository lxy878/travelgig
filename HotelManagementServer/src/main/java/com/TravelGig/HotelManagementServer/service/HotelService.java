package com.TravelGig.HotelManagementServer.service;

import java.util.List;

import com.TravelGig.HotelManagementServer.domain.Hotel;

public interface HotelService {
    public Hotel save(Hotel hotel);
    public List<Hotel> getHotelsByWord(String word);
    public Hotel findByName(String name);
    public Hotel findByHotelId(int id);
}
