package com.TravelGig.BookingServer.service;

import java.util.List;

import com.TravelGig.BookingServer.domain.BookingDetail;

public interface BookingDetailService {
    public BookingDetail save(BookingDetail bd);
    public List<BookingDetail> findBookingDetailsBy(String email, String status);
    public BookingDetail cancelBooking(int bId);
    public List<BookingDetail> completedBooking();
}
