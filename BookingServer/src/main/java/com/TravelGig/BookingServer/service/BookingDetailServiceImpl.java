package com.TravelGig.BookingServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TravelGig.BookingServer.domain.BookingDetail;
import com.TravelGig.BookingServer.repository.BookingDetailRepository;

@Service
public class BookingDetailServiceImpl implements BookingDetailService{

    @Autowired
    BookingDetailRepository bookingDetailRepository;
    
    @Override
    public BookingDetail save(BookingDetail bd) {
        
        return bookingDetailRepository.save(bd);
    }
    
}
