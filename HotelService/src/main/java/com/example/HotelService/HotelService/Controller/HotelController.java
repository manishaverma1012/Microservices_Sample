package com.example.HotelService.HotelService.Controller;

import com.example.HotelService.HotelService.Model.Hotel;
import com.example.HotelService.HotelService.Services.hotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Hotels")
public class HotelController {
    @Autowired
    private hotelService hotelservice;

    @PostMapping
    public ResponseEntity<Hotel> createHotelRatings(@RequestBody Hotel hotel)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelservice.hotelCreate(hotel));

    }
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotel()
    {
        List<Hotel> hotel1=hotelservice.getAllHotel();
        return  ResponseEntity.ok(hotel1);
    }
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getOneHotel(@PathVariable String hotelId)
    {
        Hotel hotel=hotelservice.getSingleHotel(hotelId);
        return ResponseEntity.ok(hotel);

    }
}
