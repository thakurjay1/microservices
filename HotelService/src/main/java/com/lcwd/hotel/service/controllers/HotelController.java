package com.lcwd.hotel.service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.hotel.service.entities.Hotel;
import com.lcwd.hotel.service.payloads.ApiResponse;
import com.lcwd.hotel.service.services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	//create 
	@PostMapping("/")
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		Hotel createdHotel = this.hotelService.createHotel(hotel);
		return new ResponseEntity<Hotel>(createdHotel, HttpStatus.CREATED);
	}
	
	//get all hotels
	@GetMapping("/")
	public ResponseEntity<List<Hotel>> getAllHotels(){
		List<Hotel> allHotels = this.hotelService.getAllHotels();
		return new ResponseEntity<List<Hotel>>(allHotels, HttpStatus.OK);
	}
	
	
	//get single hotel
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId){
		Hotel hotel = this.hotelService.getHotel(hotelId);
		return new ResponseEntity<Hotel>(hotel, HttpStatus.OK);
	}
	
	//delete hotel
	@DeleteMapping("/{hotelId}")
	public ResponseEntity<ApiResponse> deleteHotel(@PathVariable String hotelId){
		this.hotelService.deleteHotel(hotelId);
		ApiResponse apiResponse = ApiResponse.builder().message("Hotel deleted successfully").success(true).status(HttpStatus.OK).build();
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
	}
	
	//update hotel
	@PutMapping("/{hotelId}")
	public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel, @PathVariable String hotelId){
		Hotel updatedHotel = this.hotelService.updateHotel(hotel, hotelId);
		return new ResponseEntity<Hotel>(updatedHotel, HttpStatus.OK);
	}
}
