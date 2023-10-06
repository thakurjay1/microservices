package com.lcwd.rating.service.services;

import java.util.List;

import com.lcwd.rating.service.entities.Rating;

public interface RatingService {

	//create ratings 
	Rating createRating(Rating rating);
	
	//get all ratings
	List<Rating> getAllRatings();
	
	//get single rating
	Rating getRating(String ratingId);
	
	//get all by userId
	List<Rating> getRatingByUserId(String userId);
	
	//get all by hotel
	List<Rating> getRatingByHotelId(String hotelId);
	
	//delete rating
	void deleteRating(String ratingId);
	
	//update rating
	Rating updateRating(Rating rating, String ratingId);
}
