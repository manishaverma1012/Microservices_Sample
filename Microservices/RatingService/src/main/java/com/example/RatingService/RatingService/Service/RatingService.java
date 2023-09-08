package com.example.RatingService.RatingService.Service;

import com.example.RatingService.RatingService.Model.Rating;
import com.example.RatingService.RatingService.Repository.RatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingService {
    @Autowired
    private RatingRepo ratingRepo;
    public Rating createRating(Rating ratings)
    {
        return ratingRepo.save(ratings);

    }
    public List<Rating> getAllRatings()
    {
        return ratingRepo.findAll();


    }
    public List<Rating> getRatingByUserId(String userId)
    {
           return ratingRepo.findByUserId(userId);

    }
    public List<Rating> getRatingByHotelId(String hotelId)
    {
        return ratingRepo.findByHotelId(hotelId);

    }
    //create
    //
}
