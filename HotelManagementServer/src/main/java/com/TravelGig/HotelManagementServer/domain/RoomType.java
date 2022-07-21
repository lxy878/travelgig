package com.TravelGig.HotelManagementServer.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roomtype")
public class RoomType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int typeId;
	private String name;
	
	public RoomType(){}

	public RoomType(int id, String name){
		this.typeId = id;
		this.name = name;
	}

	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
