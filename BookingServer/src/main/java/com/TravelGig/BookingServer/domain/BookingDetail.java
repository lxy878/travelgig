package com.TravelGig.BookingServer.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BookingDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private int hotelId;
    private int hotelRoomId;
    private String hotelName;
    private String email;
    private int noGuests;
    private int noRooms;
    private String checkInDate;
    private String checkOutDate;
    private String roomType;
    private float price;
    
    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNoGuests() {
        return noGuests;
    }

    public void setNoGuests(int noGuests) {
        this.noGuests = noGuests;
    }

    public int getNoRooms() {
        return noRooms;
    }

    public void setNoRooms(int noRooms) {
        this.noRooms = noRooms;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getHotelRoomId() {
        return hotelRoomId;
    }

    public void setHotelRoomId(int hotelRoomId) {
        this.hotelRoomId = hotelRoomId;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    @Override
    public String toString() {
        return "BookingDetail [Id=" + Id + ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate
                + ", email=" + email + ", hotelId=" + hotelId + ", hotelName=" + hotelName + ", hotelRoomId="
                + hotelRoomId + ", noGuests=" + noGuests + ", noRooms=" + noRooms + ", price=" + price + ", roomType="
                + roomType + "]";
    }
    
    
}
