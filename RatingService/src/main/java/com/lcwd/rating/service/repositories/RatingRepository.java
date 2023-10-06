package com.lcwd.rating.service.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lcwd.rating.service.entities.Rating;

public interface RatingRepository extends MongoRepository<Rating, String>{

	//Custom Finder Methods
	
	List<Rating> findByUserId(String userId);
	List<Rating> findByHotelId(String hotelId);
}
