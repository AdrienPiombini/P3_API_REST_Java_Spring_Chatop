package com.P3_OpenClassRoomBackEnd.controllers;

import com.P3_OpenClassRoomBackEnd.services.user.UserResponse;
import com.P3_OpenClassRoomBackEnd.models.User;
import com.P3_OpenClassRoomBackEnd.services.user.UserService;
import com.P3_OpenClassRoomBackEnd.services.auth.AuthenticationResponse;
import com.P3_OpenClassRoomBackEnd.services.auth.AuthenticationService;
import com.P3_OpenClassRoomBackEnd.services.auth.LoginRequest;
import com.P3_OpenClassRoomBackEnd.services.auth.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "auth")
@RequiredArgsConstructor
public class UsersController {

    private final AuthenticationService authenticationService;
    private final UserService userService;

    @PostMapping("register")
    public ResponseEntity<AuthenticationResponse> register (@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("login")
    public ResponseEntity<AuthenticationResponse> login (@RequestBody LoginRequest request){
        return ResponseEntity.ok(authenticationService.login(request));
    }

    @GetMapping("me")
    public UserResponse retrieveUser(){
        User user = userService.retrieveUserByContext();
        return  userService.userResponse(user);
    }

    @GetMapping("user/{id}")
    public UserResponse retrieveUserById(@PathVariable(name = "id") Integer userId){
        User user = userService.retrieveUserById(userId);
        return  userService.userResponse(user);
    }

}

