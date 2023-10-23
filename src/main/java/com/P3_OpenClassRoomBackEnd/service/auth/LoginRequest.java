package com.P3_OpenClassRoomBackEnd.service.auth;

import com.P3_OpenClassRoomBackEnd.models.UsersModel;
import com.P3_OpenClassRoomBackEnd.repository.UsersRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

    private String email;
    String password;

    /*
    @Autowired
    private UsersRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsersModel user = userRepository.findUserByEmail(username);
        return User.builder().username(user.getName()).password(user.getPassword()).build();
    }


    public AuthenticationResponse findUserByEmail(String email) {
        UsersModel user = userRepository.findUserByEmail(email);
        AuthenticationResponse response = new AuthenticationResponse("token");
        if (user == null) {
        }
        return response;
    }

     */


}

