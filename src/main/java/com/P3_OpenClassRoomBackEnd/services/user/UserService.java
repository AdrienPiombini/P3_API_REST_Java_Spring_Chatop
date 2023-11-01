package com.P3_OpenClassRoomBackEnd.services.user;

import com.P3_OpenClassRoomBackEnd.mappers.UsersMapper;
import com.P3_OpenClassRoomBackEnd.models.User;
import com.P3_OpenClassRoomBackEnd.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UsersMapper usersMapper;
    private final UsersRepository usersRepository;

    public User retrieveUserByContext(){
        String authEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        var usersModels = usersRepository.findByEmail(authEmail);
        return usersModels.get();
    }

    public UserResponse userResponse(User user) {
        return usersMapper.fromUserModel(user);
    }


    public User retrieveUserById(Integer userId) {
        var usersModel =  usersRepository.findById(userId);
        return usersModel.get();
    }

}
