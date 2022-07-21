package com.TravelGig.HotelManagementServer.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.TravelGig.HotelManagementServer.domain.Amenities;
import com.TravelGig.HotelManagementServer.domain.Hotel;
import com.TravelGig.HotelManagementServer.domain.HotelRoom;
import com.TravelGig.HotelManagementServer.domain.RoomType;
import com.TravelGig.HotelManagementServer.repository.AmenitiesRepository;
import com.TravelGig.HotelManagementServer.repository.RoomTypeRepository;

@Component
public class DataComponent {
    
    @Autowired
    AmenitiesRepository amenitiesRepository;

    @Autowired
    RoomTypeRepository roomTypeRepository;

    public void addHotels(){
        createAmenites();
        createRoomTypes();
    }

    private void createHotel(){
        Hotel h = new Hotel();
        
        h.setHotelId(1);
        h.setHotelName("Row NYC at Times Square");
        h.setAddress("700 8th Avenue");
        h.setCity("New York");
        h.setState("NY");
        h.setStarRating(4);
        h.setAveragePrice(1025);
        h.setDiscount(0.70);
        h.setDescription("Offering a front row view to Times Square, this Theater District hotel features a fitness center, concierge service and a business center. Rockefeller Center is a short walking distance away.\nA flat-screen cable TV, iPod docking station and safe for a laptop are offered in each room at Row NYC. Blackout curtains and a desk are also included. Row NYC is a family and pet-friendly hotel.\nLocated in the lobby, the District M Bar serves a daily continental breakfast each morning. In the evening, District M comes alive featuring a digital art gallery, drinks including a specialty cocktail list, dinner and live music (Thursday - Saturday).\nThe on-site Sugar Factory offers an assortment of pastries, milkshakes, sandwiches, ice cream sundaes and more.\nFor added convenience, information and arrangements for shows, transportation and shopping are available through the concierge services.\nPlenty of shops and dining are within walking distance of the hotel. Radio City Music Hall, Madison Square Garden, the Empire State Building, and Javits Convention Center are 15 minutes’ walk away.\nThis is our guests' favorite part of New York, according to independent reviews.");
        h.setEmail("some@some");
        h.setMobile("1234567890");
        h.setImageURL("https://t-cf.bstatic.com/xdata/images/hotel/max1280x900/27228652.jpg?k=633141f7583e8b6109b6272be90d2eb3edef6b538fd7ad79dceedd6ef80520a7&o=&hp=1");
        h.setTimesBooked(3);

        
        // private Set<Amenities> amenities;
        // private Set<HotelRoom> hotelRooms;
        // private Set<String> hotelAmenityNames;
    }

    private void createHotelRoom(Hotel hotel){	
        HotelRoom hr = new HotelRoom();
        hr.setHotelRoomId(hotel.getHotelId());
        hr.setNoRooms(1);
        hr.setPrice(200.00f);
        hr.setDiscount(0.70f);
        hr.setDescription("");
        // private String description;
        // private String policies;
            
        // private String hotelName;
        
        // private String roomType;
        
        // private RoomType type;
        // private Set<Amenities> amenities;
        // private Set<String> hotelRoomAmenityNames
    }

    public void createAmenites(){
        
        String[] a = { "Free WiFi",
            "Non-smoking rooms",
            "24-hour front desk",
            "Facilities for disabled guests",
            "Fitness center",
            "Parking",
            "Pet friendly",
            "Restaurant",
            "Family rooms",
            "Room service",
            "Airport shuttle",
            "Swimming pool",
            "Spa",
            "Electric vehicle charging station",
            "Private bathroom",
            "Air conditioning",
            "Laptop-friendly workspace",
            "Bathtub",
            "Flat-screen TV",
            "Soundproof",
            "View",
            "Coffee/Tea maker",
            "Coffee machine",
            "Kitchen/Kitchenette"
        };
        for(int i=0; i<a.length; i++){
            amenitiesRepository.save(new Amenities(i+1, a[i]));
        }
    }

    public void createRoomTypes(){
        String[] room = {
            "Single room",
            "Double room", 
            "Triple room",
            "Quad room",
            "Standard room",
            "Deluxe room",
            "Joint room",
            "Connecting room",
            "Suite",
            "Apartment-style",
            "Accessible room"
        };

        for(int i=0; i<room.length; i++){
            roomTypeRepository.save(new RoomType(i+1, room[i]));
        }
    }
}
