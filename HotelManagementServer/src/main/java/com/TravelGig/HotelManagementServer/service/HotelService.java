package com.TravelGig.HotelManagementServer.service;

import java.util.List;

import com.TravelGig.HotelManagementServer.domain.Hotel;
import com.TravelGig.HotelManagementServer.domain.SearchHotel;

public interface HotelService {
    public Hotel save(Hotel hotel);
    public List<Hotel> getHotelsByWord(String word);
    public Hotel findByName(String name);
    public Hotel findByHotelId(int id);

    public List<Hotel> findAllByOthers(SearchHotel sh);
}
