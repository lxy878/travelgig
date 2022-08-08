package com.TravelGig.BookingServer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TravelGig.BookingServer.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{
    public List<Comment> findAllByUserIdAndHotelId(String userId, int hotelId);
    public List<Comment> findAllByHotelId(int hotelId);
}
