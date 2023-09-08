package com.SpringBootMicroservicesProject.UserService.External.Service;

import com.SpringBootMicroservicesProject.UserService.Model.Ratings;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
@Service //for testing purpose because we are using the  rating service to test methods in springboot application test
@FeignClient(name="RATING-SERVICE")
public interface RatingService {

    @PutMapping("/ratings/{ratingId}")
    public Ratings updaterating(@PathVariable("ratingId") String ratingId,Ratings rating);
    @PostMapping("/ratings")
    public Ratings createRatings(Ratings values);

    @DeleteMapping("/ratings/{ratingId}")
    public void deleteRating(@PathVariable String ratingId);

}
