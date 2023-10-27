package com.P3_OpenClassRoomBackEnd.DTO;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Time;


@Data
@Component
public class RentalsDao {

    private Integer id;

    private UsersDao usersDao;
    private String email;
    private String name;
    private Time created_at;
    private Time updated_at;



}

