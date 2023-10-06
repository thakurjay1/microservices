package com.lcwd.user.service.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.lcwd.rating.service.payloads.ApiResponse;
import com.lcwd.user.service.entities.Rating;

@FeignClient(name = "RATING-SERVICE")
@Service
@SuppressWarnings("unused")
public interface RatingService {

	//get
	
	
	//post
	@PostMapping("/ratings/")
	Rating createRating(Rating values);
	
	//put
	@PutMapping("/ratings/{ratingId}")
	Rating updateRating(Rating rating, @PathVariable String ratingId);
	
	@DeleteMapping("/ratings/{ratingId}")
	public ApiResponse deleteRating(@PathVariable String ratingId);
}
