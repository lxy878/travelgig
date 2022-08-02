package com.TravelGig.BookingServer.service;

import java.util.List;
import java.util.Optional;

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
        bd.setStatus("booked");
        return bookingDetailRepository.save(bd);
    }
    
    @Override
    public List<BookingDetail> findBookingDetailsBy(String email, String status){
        return bookingDetailRepository.findAllByEmailAndStatus(email, status);
    }

    @Override
    public BookingDetail cancelBooking(int bId){
        Optional<BookingDetail> obd = bookingDetailRepository.findById(bId);
        if(!obd.isPresent()){
            return null;
        }
        BookingDetail bd = obd.get();
        bd.setStatus("cancelled");
        return bookingDetailRepository.save(bd);
    }
}
