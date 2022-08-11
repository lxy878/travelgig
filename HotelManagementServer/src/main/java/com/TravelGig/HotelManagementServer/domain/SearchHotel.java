package com.TravelGig.HotelManagementServer.domain;

import java.util.ArrayList;
import java.util.List;

public class SearchHotel{
    private String location;
    private double price;
    private List<Integer> stars = new ArrayList<>();
    private List<String> amenities = new ArrayList<>();
    
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public List<Integer> getStars() {
        return stars;
    }
    public void setStars(List<Integer> stars) {
        this.stars = stars;
    }
    public List<String> getAmenities() {
        return amenities;
    }
    public void setAmenities(List<String> amenities) {
        this.amenities = amenities;
    }
    @Override
    public String toString() {
        return "searchHotel [amenities=" + amenities + ", location=" + location + ", price=" + price + ", stars="
                + stars + "]";
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
