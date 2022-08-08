package com.TravelGig.HotelManagementServer.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.TravelGig.HotelManagementServer.domain.Comment;
import com.TravelGig.HotelManagementServer.domain.Hotel;
import com.TravelGig.HotelManagementServer.domain.HotelRoom;
import com.TravelGig.HotelManagementServer.domain.RoomType;
import com.TravelGig.HotelManagementServer.service.CommentService;
import com.TravelGig.HotelManagementServer.service.HotelRoomService;
import com.TravelGig.HotelManagementServer.service.HotelService;
import com.TravelGig.HotelManagementServer.service.RoomTypeService;


@RestController
public class HotelController {
    @Autowired
    HotelService hotelService;

    @Autowired
    HotelRoomService hotelRoomService;

    @Autowired
    RoomTypeService roomTypeService;

    @Autowired
    CommentService commentService;

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
        return hotelRoomService.save(room);
    }

    @GetMapping("/getRooms/{hotelId}")
    public Set<HotelRoom> getRooms(@PathVariable int hotelId){
        Hotel hotel = hotelService.findByHotelId(hotelId);
        return hotel.getHotelRooms();
    }

    @GetMapping("/getRoomTypes")
    public List<RoomType> getRoomTypes(){ 
        return roomTypeService.findAll();
    }

    @GetMapping("/getHotel/{hotelId}")
    private Hotel getHotelBy(@PathVariable int hotelId){
        return hotelService.findByHotelId(hotelId);
    }

    @GetMapping("/getComments/{hotelId}")
    private List<Comment> getCommentsByHotel(@PathVariable int hotelId){
        return commentService.getCommentsBy(hotelId);
    }
}
