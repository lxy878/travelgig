package com.TravelGig.HotelManagementServer.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="hotel_rooms")
public class HotelRoom {		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hotelRoomId; //PK	
	@ManyToOne
	private RoomType type;
	@ManyToMany
	private Set<Amenities> amenities= new HashSet<>();
	// 1-2
	private int noRooms;
	// 50-250 per night
	private float price;
	private float discount;
	private String description;
	private String policies;
		
	@Transient
	private String hotelName;
	
	@Transient
	private String roomType;
	
	@Transient
	private Set<String> hotelRoomAmenityNames = new HashSet<>();
	
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}			
	public int getHotelRoomId() {
		return hotelRoomId;
	}
	public void setHotelRoomId(int hotelRoomId) {
		this.hotelRoomId = hotelRoomId;
	}		
	public RoomType getType() {
		return type;
	}
	public void setType(RoomType type) {
		this.type = type;
	}
	
	public Set<Amenities> getAmenities() {
		return amenities;
	}
	public void setHotelRoomAmenities(Set<Amenities> hotelRoomAmenities) {
		this.amenities = hotelRoomAmenities;
	}
	public Set<String> getHotelRoomAmenityNames() {
		return hotelRoomAmenityNames;
	}
	public void setHotelRoomAmenityNames(Set<String> hotelRoomAmenityNames) {
		this.hotelRoomAmenityNames = hotelRoomAmenityNames;
	}
	public int getNoRooms() {
		return noRooms;
	}
	public void setNoRooms(int noRooms) {
		this.noRooms = noRooms;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPolicies() {
		return policies;
	}
	public void setPolicies(String policies) {
		this.policies = policies;
	}
	@Override
	public String toString() {
		return "HotelRoom [amenities=" + amenities + ", description=" + description + ", discount=" + discount
				+ ", hotelName=" + hotelName + ", hotelRoomAmenityNames=" + hotelRoomAmenityNames + ", hotelRoomId="
				+ hotelRoomId + ", noRooms=" + noRooms + ", policies=" + policies + ", price=" + price + ", roomType="
				+ roomType + ", type=" + type + "]";
	}
	
	
}
