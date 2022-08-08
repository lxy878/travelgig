package com.TravelGig.HotelManagementServer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TravelGig.HotelManagementServer.domain.Comment;
import com.TravelGig.HotelManagementServer.repository.CommentRepository;

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
    
}
