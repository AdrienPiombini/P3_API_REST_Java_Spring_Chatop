package com.P3_OpenClassRoomBackEnd.mappers;

import com.P3_OpenClassRoomBackEnd.services.user.UserResponse;
import com.P3_OpenClassRoomBackEnd.models.User;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;


@Service
public class UsersMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    public UserResponse fromUserModel(User user) {
        return modelMapper.map(user, UserResponse.class);
    }

    public User fromUserDao(UserResponse userResponse){
        return  modelMapper.map(userResponse, User.class);
    }


}
