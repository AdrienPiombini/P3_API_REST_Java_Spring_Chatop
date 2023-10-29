package com.P3_OpenClassRoomBackEnd.DTO;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;


@Data
@Component
public class RentalsDao {

    private Integer id;
    private String name;
    private Integer surface;
    private Integer price;
    private String picture;
    private String description;
    private Date created_at;
    private Date updated_at;
    private Integer owner_id;




}

