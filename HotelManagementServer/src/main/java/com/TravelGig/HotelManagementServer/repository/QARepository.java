package com.TravelGig.HotelManagementServer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TravelGig.HotelManagementServer.domain.QA;

public interface QARepository extends JpaRepository<QA, Integer>{
    public List<QA> findAllByHotelIdAndStatus(int hotelId, String status);
    public List<QA> findAllByStatus(String status);
    public List<QA> findAllByStatusAndCreateDateBefore(String status, String date);
}
