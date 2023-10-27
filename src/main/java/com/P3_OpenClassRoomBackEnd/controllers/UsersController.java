package com.P3_OpenClassRoomBackEnd.controllers;

import com.P3_OpenClassRoomBackEnd.DTO.UsersDao;
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

    @PostMapping("register")
    public ResponseEntity<AuthenticationResponse> register (
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("login")
    public ResponseEntity<AuthenticationResponse> login (
            @RequestBody LoginRequest request
    ){
        return ResponseEntity.ok(authenticationService.login(request));
    }

    @GetMapping("me")
    public UsersDao me(@RequestHeader("Authorization") String token ){
        return authenticationService.me(token);
    }


    @GetMapping("test")
    public String test(){
        return "Welcome Bro !";
    }

}

