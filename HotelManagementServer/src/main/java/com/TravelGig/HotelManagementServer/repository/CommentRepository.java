package com.TravelGig.HotelManagementServer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TravelGig.HotelManagementServer.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{
    public List<Comment> findAllByHotelId(int hotelId);
}
