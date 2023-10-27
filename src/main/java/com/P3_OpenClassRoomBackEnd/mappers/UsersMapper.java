package com.P3_OpenClassRoomBackEnd.mappers;

import com.P3_OpenClassRoomBackEnd.DTO.UsersDao;
import com.P3_OpenClassRoomBackEnd.models.UsersModel;
import org.springframework.stereotype.Service;

@Service
public class UsersMapper {

    public UsersDao fromUserModel(UsersModel usersModel){
        UsersDao usersDao = new UsersDao();
        usersDao.setName(usersModel.getName());
        usersDao.setEmail(usersModel.getEmail());
        usersDao.setCreated_at((usersModel.getCreated_at()));
        usersDao.setUpdated_at(usersModel.getUpdated_at());
        return usersDao;
    }

    public UsersModel fromUserDao(UsersDao usersDao){
        return UsersModel.builder()
                .name(usersDao.getName())
                .email(usersDao.getEmail())
                .created_at(usersDao.getCreated_at())
                .updated_at(usersDao.getUpdated_at())
                .build();

    }
}
