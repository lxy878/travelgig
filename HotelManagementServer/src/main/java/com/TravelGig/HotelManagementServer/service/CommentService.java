package com.TravelGig.HotelManagementServer.service;

import java.util.List;

import com.TravelGig.HotelManagementServer.domain.Comment;

public interface CommentService {
    public List<Comment> getCommentsBy(int hotelId);
}
