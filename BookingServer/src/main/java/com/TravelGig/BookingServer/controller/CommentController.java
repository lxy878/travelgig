package com.TravelGig.BookingServer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.TravelGig.BookingServer.domain.Comment;
import com.TravelGig.BookingServer.domain.Hotel;
import com.TravelGig.BookingServer.service.CommentService;
import com.TravelGig.BookingServer.service.HotelService;


@RestController
public class CommentController {
    @Autowired
    CommentService commentService;

    @Autowired
    HotelService hotelService;

    @PostMapping("/saveComment")
    private Comment saveComment(@RequestBody Comment comment){
        Hotel h = hotelService.geHotel(comment.getHotelName());
        comment.setHotelId(h.getHotelId());
        Comment c = commentService.save(comment);
        int sum = commentService.sumRate(h.getHotelId());
        int count = commentService.countRate(h.getHotelId());
        h.setStarRating(sum/count);
        hotelService.update(h);
        return c;
    }

    @GetMapping("/getComments/{hotelId}")
    private List<Comment> getCommentsByHotel(@PathVariable int hotelId){
        return commentService.getCommentsBy(hotelId);
    }

    @GetMapping(value="/getComments/{hotelId}/{uId}")
    public List<Comment> getCommentsByHotelAndUser(@PathVariable int hotelId, @PathVariable String uId) {
        return commentService.getCommentsBy(hotelId, uId);
    }
}
