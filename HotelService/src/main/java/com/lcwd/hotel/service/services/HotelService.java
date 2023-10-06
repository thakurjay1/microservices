package com.lcwd.hotel.service.services;

import java.util.List;

import com.lcwd.hotel.service.entities.Hotel;

public interface HotelService {

	//create
	Hotel createHotel(Hotel hotel);
	
	//getAll
	List<Hotel> getAllHotels();
	
	//get single 
	Hotel getHotel(String hotelId);
	
	//delete 
	void deleteHotel(String hotelId);
	
	//update
	Hotel updateHotel(Hotel hotel, String hotelId);
}
