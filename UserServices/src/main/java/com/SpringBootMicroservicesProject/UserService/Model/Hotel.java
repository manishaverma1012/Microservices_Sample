package com.SpringBootMicroservicesProject.UserService.Model;

import lombok.*;


@Setter
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
 public class Hotel {

    private String hotelId;
    private String name;
    private String location;
    private String about;
}

