package com.TravelGig.BookingServer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TravelGig.BookingServer.domain.BookingDetail;

public interface BookingDetailRepository extends JpaRepository<BookingDetail, Integer>{
    public List<BookingDetail> findAllByEmailAndStatus(String email, String status);
}
