package com.P3_OpenClassRoomBackEnd.services.user;

import com.P3_OpenClassRoomBackEnd.mappers.UsersMapper;
import com.P3_OpenClassRoomBackEnd.models.User;
import com.P3_OpenClassRoomBackEnd.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UsersMapper usersMapper;
    private final UsersRepository usersRepository;

    public User retrieveUserByContext(){
        String authEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> userModel = usersRepository.findByEmail(authEmail);
        if(userModel.isPresent()){
            return userModel.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public UserResponse userResponse(User user) {
        return usersMapper.fromUserModel(user);
    }


    public Optional<User> retrieveUserById(Integer userId) {
        return usersRepository.findById(userId);
    }

}
