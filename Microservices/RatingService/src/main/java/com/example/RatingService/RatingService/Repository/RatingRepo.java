package com.example.RatingService.RatingService.Repository;

import com.example.RatingService.RatingService.Model.Rating;
import com.example.RatingService.RatingService.Model.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepo extends MongoRepository<Rating,String> {

    //custom findermethod
    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);

}
