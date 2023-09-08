package com.SpringBootMicroservicesProject.UserService.Service;

import com.SpringBootMicroservicesProject.UserService.Exception.ResourceNotFoundException;
import com.SpringBootMicroservicesProject.UserService.External.Service.HotelService;
import com.SpringBootMicroservicesProject.UserService.Model.Hotel;
import com.SpringBootMicroservicesProject.UserService.Model.Ratings;
import com.SpringBootMicroservicesProject.UserService.Model.User;
import com.SpringBootMicroservicesProject.UserService.Repository.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class userService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HotelService hotelService;

    private Logger logger= LoggerFactory.getLogger(userService.class);



    public User saveUser(User user)
    {
        String randomId=UUID.randomUUID().toString();
        user.setUserId(randomId);

            return userRepo.save(user);


    }
    public List<User> getAllUser()
    {
        return userRepo.findAll();

    }
   public User getUser(String userId)
   {
       User user=userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User with given id not found"+ userId));
       //fetch rating to get the rating along wtih this data from rating service
       Ratings[] ratingArray=restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Ratings[].class);
       logger.info("{}", ratingArray);
       List<Ratings> ratingForUser=Arrays.stream(ratingArray).toList();
       List<Ratings> ratingList=ratingForUser.stream().map(item-> {
//           ResponseEntity<Hotel> forEntity=restTemplate.getForEntity("http://HOTEL-SERVICE/Hotels/" +item.getHotelId(), Hotel.class);
           Hotel hotel=hotelService.getHotel(item.getHotelId());
//           logger.info("response",forEntity.getStatusCode());
           item.setHotel(hotel);
           return item;
       }).collect(Collectors.toList());
//
       user.setRatings(ratingList);
       return user;


//       List<Ratings> hotelratingfetched=
//           //api call to hotel service to get the hotel
//           //link
//           System.out.println(item.getHotelId());
//           ResponseEntity<Hotel> forEntity=restTemplate.getForEntity("http://HOTEL-SERVICE/Hotels/"+item.getHotelId(), Hotel.class);
//           Hotel hotels=forEntity.getBody();
//           logger.info("reponse status" , forEntity.getStatusCode());
//            item.setHotel(hotels);
//            return new Ratings();
//       }).collect(Collectors.toList());

//       user.setRatings(hotelratingfetched);
//       return user;


   }
   public void deleteUser(String userId)
   {
       userRepo.deleteById(userId);
   }

   //TODO:Delete
    //TODO:Update

}
