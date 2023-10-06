package com.lcwd.hotel.service.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.hotel.service.entities.Hotel;
import com.lcwd.hotel.service.exceptions.ResourceNotFoundException;
import com.lcwd.hotel.service.repositories.HotelRepository;
import com.lcwd.hotel.service.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public Hotel createHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		String randomHotelId = UUID.randomUUID().toString();
		hotel.setHotelId(randomHotelId);
		Hotel savedHotel = this.hotelRepository.save(hotel);
		return savedHotel;
	}

	@Override
	public List<Hotel> getAllHotels() {
		// TODO Auto-generated method stub
		List<Hotel> allHotels = this.hotelRepository.findAll();
		return allHotels;
	}

	@Override
	public Hotel getHotel(String hotelId) {
		// TODO Auto-generated method stub
		Hotel hotel = this.hotelRepository.findById(hotelId).orElseThrow(()->new ResourceNotFoundException("Hotel with given id is not found on server!! : "+hotelId));
		return hotel;
	}

	@Override
	public void deleteHotel(String hotelId) {
		// TODO Auto-generated method stub
		Hotel hotel = this.hotelRepository.findById(hotelId).orElseThrow(()->new ResourceNotFoundException("Hotel with given id is not found on server!! : "+hotelId));
		this.hotelRepository.delete(hotel);
	}

	@Override
	public Hotel updateHotel(Hotel hotel, String hotelId) {
		// TODO Auto-generated method stub
		Hotel hotel1 = this.hotelRepository.findById(hotelId).orElseThrow(()->new ResourceNotFoundException("Hotel with given id is not found on server!! : "+hotelId));
		hotel1.setHotelId(hotel.getHotelId());
		hotel1.setName(hotel.getName());
		hotel1.setLocation(hotel.getLocation());
		hotel1.setAbout(hotel.getAbout());
		Hotel savedHotel = this.hotelRepository.save(hotel1);
		return savedHotel;
	}
	
}
