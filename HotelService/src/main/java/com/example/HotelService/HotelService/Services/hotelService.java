package com.example.HotelService.HotelService.Services;

import com.example.HotelService.HotelService.Exception.ResourceNotFound;
import com.example.HotelService.HotelService.Model.Hotel;
import com.example.HotelService.HotelService.Repository.hotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class hotelService {
    @Autowired
    private hotelRepo hotelrepo;
    public Hotel hotelCreate(Hotel hotel)
    {
        String hotelrandomId= UUID.randomUUID().toString();
        hotel.setHotelId(hotelrandomId);
        return hotelrepo.save(hotel);
    }
    public List<Hotel> getAllHotel()
    {
        return hotelrepo.findAll();

    }
    public Hotel getSingleHotel(String id)
    {
        return hotelrepo.findById(id).orElseThrow(()-> new ResourceNotFound("Id not found"+ id));
    }
    //create hotel
    //get all
    // get single

}
