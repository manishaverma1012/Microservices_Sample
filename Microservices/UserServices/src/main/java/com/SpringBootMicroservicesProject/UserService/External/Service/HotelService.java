package com.SpringBootMicroservicesProject.UserService.External.Service;

import com.SpringBootMicroservicesProject.UserService.Model.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="HOTEL-SERVICE")
public interface HotelService {
    @GetMapping("/Hotels/{hotelId}")
    Hotel getHotel(@PathVariable("hotelId") String hotelId);
}

