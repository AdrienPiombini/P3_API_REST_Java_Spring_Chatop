package com.P3_OpenClassRoomBackEnd.services.rental;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RentalRequest {
     private String name;
     private Float surface;
     private Float price;
     private MultipartFile picture;
     private String Description;

}
