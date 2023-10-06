package com.lcwd.rating.service.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.rating.service.entities.Rating;
import com.lcwd.rating.service.exceptions.ResourceNotFoundException;
import com.lcwd.rating.service.repositories.RatingRepository;
import com.lcwd.rating.service.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService{
	
	@Autowired
	private RatingRepository ratingRepository;
	

	@Override
	public Rating createRating(Rating rating) {
		// TODO Auto-generated method stub
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getAllRatings() {
		// TODO Auto-generated method stub
		return ratingRepository.findAll();
	}

	@Override
	public Rating getRating(String ratingId) {
		// TODO Auto-generated method stub
		Rating rating = this.ratingRepository.findById(ratingId).orElseThrow(()->new ResourceNotFoundException("Rating with given id is not found on server!! : "+ratingId));
		return rating;
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		// TODO Auto-generated method stub
		return ratingRepository.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		// TODO Auto-generated method stub
		return ratingRepository.findByHotelId(hotelId);
	}

	@Override
	public void deleteRating(String ratingId) {
		// TODO Auto-generated method stub
		Rating rating = this.ratingRepository.findById(ratingId).orElseThrow(()->new ResourceNotFoundException("Rating with given id is not found on server!! : "+ratingId));
		this.ratingRepository.delete(rating);
	}

	@Override
	public Rating updateRating(Rating rating, String ratingId) {
		// TODO Auto-generated method stub
		Rating rating1 = this.ratingRepository.findById(ratingId).orElseThrow(()->new ResourceNotFoundException("Rating with given id is not found on server!! : "+ratingId));
		rating1.setRatingId(rating.getRatingId());
		rating1.setRating(rating.getRating());
		rating1.setFeedback(rating.getFeedback());
		rating1.setUserId(rating.getUserId());
		rating1.setHotelId(rating.getHotelId());
		return ratingRepository.save(rating1);
	}

}
