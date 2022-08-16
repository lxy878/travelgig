package com.TravelGig.BookingServer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TravelGig.BookingServer.domain.QA;

public interface QARepository extends JpaRepository<QA, Integer>{
    public List<QA> findAllByHotelIdAndStatus(int hotelId, String status);
    public List<QA> findAllByStatus(String status);
    public List<QA> findAllByCreateDateBefore(String date);
}
