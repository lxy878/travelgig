package com.TravelGig.BookingServer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.TravelGig.BookingServer.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{
    public List<Comment> findAllByUserIdAndHotelId(String userId, int hotelId);
    public List<Comment> findAllByHotelId(int hotelId);

    @Query(value = "select count(rate) from comment where hotel_id=?1", nativeQuery = true)
    public int countRate(int hotelId);

    @Query(value = "select sum(rate) from comment where hotel_id=?1", nativeQuery = true)
    public int sumRate(int hotelId);
    
}
