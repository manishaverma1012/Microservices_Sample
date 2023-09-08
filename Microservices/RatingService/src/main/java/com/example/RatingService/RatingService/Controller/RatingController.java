package com.example.RatingService.RatingService.Controller;

import com.example.RatingService.RatingService.Model.Rating;
import com.example.RatingService.RatingService.Model.Rating;
import com.example.RatingService.RatingService.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    private RatingService ratingService;
    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody Rating ratings)
    {

        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(ratings));
    }
    @GetMapping
    public ResponseEntity<List<Rating>> getAllratings()
    {
        return ResponseEntity.ok(ratingService.getAllRatings());

    }
    @GetMapping("/users/{userId}")

    public ResponseEntity<List<Rating>> getRatingByUserID(@PathVariable String userId)
    {
        return ResponseEntity.ok(ratingService.getRatingByUserId(userId));

    }
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelID(@PathVariable String hotelId)
    {
        return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));

    }

}
