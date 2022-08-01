package com.TravelGig.BookingServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TravelGig.BookingServer.domain.BookingDetail;

public interface BookingDetailRepository extends JpaRepository<BookingDetail, Integer>{
    
}
