package com.SpringBootMicroservicesProject.UserService;

import com.SpringBootMicroservicesProject.UserService.External.Service.RatingService;
import com.SpringBootMicroservicesProject.UserService.Model.Ratings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceApplicationTests {

	@Autowired
	private RatingService ratingService;

	@Test
	void contextLoads() {
	}
//   @Test
//	void createRating()
//	{
//		Ratings rating= Ratings.builder().rating(10).userId("").hotelId("").feedback("this is created using feign client").build();
//	    Ratings savedrating=ratingService.createRatings(rating);
//		System.out.println("new rating created");
//	}



}
