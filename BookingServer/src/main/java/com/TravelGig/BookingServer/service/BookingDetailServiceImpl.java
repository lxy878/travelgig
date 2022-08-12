package com.TravelGig.BookingServer.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TravelGig.BookingServer.domain.BookingDetail;
import com.TravelGig.BookingServer.domain.Hotel;
import com.TravelGig.BookingServer.domain.User;
import com.TravelGig.BookingServer.repository.BookingDetailRepository;

@Service
public class BookingDetailServiceImpl implements BookingDetailService{

    @Autowired
    BookingDetailRepository bookingDetailRepository;
    
    @Autowired
    HotelService hotelService;

    @Autowired
    UserService userService;

    @Override
    public BookingDetail save(BookingDetail bd) {
        bd.setStatus("booked");
        Hotel h = hotelService.getHotel(bd.getHotelId());
        bd.setCheckInTime(h.getTimesBooked());
        bd.setCheckOutTime(h.getTimesBooked());
        User u = userService.getUser(bd.getEmail());
        if(u == null){
            return null;
        }
        bd.setUserName(u.getLastName()+", "+u.getFirstName());
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

    @Override
    public List<BookingDetail> completedBooking(){
        String currentDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        List<BookingDetail> bookings = bookingDetailRepository.findAllByStatusAndCheckInDateBefore("booked", currentDate);
        for(BookingDetail bd : bookings){
            bd.setStatus("completed");
        }
        bookingDetailRepository.saveAll(bookings);
        return bookings;
    }
}
