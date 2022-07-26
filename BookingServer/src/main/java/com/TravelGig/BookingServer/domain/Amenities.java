package com.TravelGig.BookingServer.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="amenities")
public class Amenities {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int a_id;
	private String name;
	
	public Amenities(){}

	public Amenities(int id, String name){
		this.a_id = id;
		this.name = name;
	}

	public int getA_id() {
		return a_id;
	}
	public void setA_id(int a_id) {
		this.a_id = a_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
