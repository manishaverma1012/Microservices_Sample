package com.example.HotelService.HotelService.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Hotels")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Hotel {
    @Id
    private String hotelId;
    private String name;
    private String location;
    private String about;

}
