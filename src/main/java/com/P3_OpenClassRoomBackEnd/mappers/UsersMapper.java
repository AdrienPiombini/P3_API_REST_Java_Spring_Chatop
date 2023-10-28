package com.P3_OpenClassRoomBackEnd.mappers;

import com.P3_OpenClassRoomBackEnd.DTO.UsersDao;
import com.P3_OpenClassRoomBackEnd.models.UsersModel;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;


@Service
public class UsersMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    public UsersDao fromUserModel(UsersModel usersModel) {
        return modelMapper.map(usersModel, UsersDao.class);
    }

    public  UsersModel fromUserDao(UsersDao usersDao){
        return  modelMapper.map(usersDao, UsersModel.class);
    }

/*
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

 */
}
