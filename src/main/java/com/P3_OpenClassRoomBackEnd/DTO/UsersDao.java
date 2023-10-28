package com.P3_OpenClassRoomBackEnd.DTO;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Data
@Component
public class UsersDao  {

    private Integer id;
    private String email;
    private String name;
    private Date created_at;
    private Date updated_at;

}

