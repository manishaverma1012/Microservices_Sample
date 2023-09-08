package com.example.HotelService.HotelService.Repository;

import com.example.HotelService.HotelService.Model.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface hotelRepo extends MongoRepository<Hotel,String> {

}
