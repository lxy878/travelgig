package com.TravelGig.BookingServer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.TravelGig.BookingServer.domain.Comment;
import com.TravelGig.BookingServer.service.CommentService;


@RestController
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping("/saveComment")
    private Comment saveComment(@RequestBody Comment comment){
        return commentService.save(comment);
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
