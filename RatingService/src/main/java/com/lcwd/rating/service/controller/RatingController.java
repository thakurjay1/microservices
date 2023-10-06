package com.lcwd.rating.service.controller;

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

import com.lcwd.rating.service.entities.Rating;
import com.lcwd.rating.service.payloads.ApiResponse;
import com.lcwd.rating.service.services.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	
	@Autowired
	private RatingService ratingService;

	//create rating
	
	@PostMapping("/")
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
		Rating createdRating = this.ratingService.createRating(rating);
		return new ResponseEntity<Rating>(createdRating, HttpStatus.CREATED);
	}
	
	//get all rating
	
	@GetMapping("/")
	public ResponseEntity<List<Rating>> getAllRating(){
		List<Rating> allRatings = this.ratingService.getAllRatings();
		return new ResponseEntity<List<Rating>>(allRatings, HttpStatus.OK);
	}
	
	//get rating by Id
	
	@GetMapping("/{ratingId}")
	public ResponseEntity<Rating> getRating(@PathVariable String ratingId){
		Rating rating = this.ratingService.getRating(ratingId);
		return new ResponseEntity<Rating>(rating, HttpStatus.OK);
	}
	
	//get rating by userId
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){
		List<Rating> ratingByUserId = this.ratingService.getRatingByUserId(userId);
		return new ResponseEntity<List<Rating>>(ratingByUserId, HttpStatus.OK);
	}
	
	//get rating by hotelId
	
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){
		List<Rating> ratingByHotelId = this.ratingService.getRatingByHotelId(hotelId);
		return new ResponseEntity<List<Rating>>(ratingByHotelId, HttpStatus.OK);
	}
	
	//delete rating
	
	@DeleteMapping("/{ratingId}")
	public ResponseEntity<ApiResponse> deleteRating(@PathVariable String ratingId){
		this.ratingService.deleteRating(ratingId);
		ApiResponse apiResponse = ApiResponse.builder().message("Rating deleted successfully...").success(true).status(HttpStatus.OK).build();
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
	}
	
	//update rating
	
	@PutMapping("/{ratingId}")
	public ResponseEntity<Rating> updateRating(@RequestBody Rating rating, @PathVariable String ratingId){
		Rating updatedRating = this.ratingService.updateRating(rating, ratingId);
		return new ResponseEntity<Rating>(updatedRating, HttpStatus.OK);
	}
}
