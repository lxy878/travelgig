package com.TravelGig.BookingServer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TravelGig.BookingServer.domain.Comment;
import com.TravelGig.BookingServer.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    CommentRepository commentRepository;

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> getCommentsBy(int hotelId) {
        
        return commentRepository.findAllByHotelId(hotelId);
    }

    @Override
    public List<Comment> getCommentsBy(int hotelId, String uId) {
        
        return commentRepository.findAllByUserIdAndHotelId(uId, hotelId);
    }
    
}
