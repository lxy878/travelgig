package com.TravelGig.BookingServer.service;

import java.util.List;

import com.TravelGig.BookingServer.domain.Comment;

public interface CommentService {
    public Comment save(Comment comment);
    public List<Comment> getCommentsBy(int hotelId);
    public List<Comment> getCommentsBy(int hotelId, String uId);
}
