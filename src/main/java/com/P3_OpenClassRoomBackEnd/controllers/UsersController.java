package com.P3_OpenClassRoomBackEnd.controllers;

import com.P3_OpenClassRoomBackEnd.services.user.UserResponse;
import com.P3_OpenClassRoomBackEnd.models.User;
import com.P3_OpenClassRoomBackEnd.services.user.UserService;
import com.P3_OpenClassRoomBackEnd.services.auth.AuthenticationResponse;
import com.P3_OpenClassRoomBackEnd.services.auth.AuthenticationService;
import com.P3_OpenClassRoomBackEnd.services.auth.LoginRequest;
import com.P3_OpenClassRoomBackEnd.services.auth.RegisterRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;


@RestController
@RequestMapping(value = "auth")
@RequiredArgsConstructor
@Tag( name = "User")
public class UsersController {

    private final AuthenticationService authenticationService;
    private final UserService userService;

    @PostMapping("register")
    public ResponseEntity<AuthenticationResponse> register (@RequestBody RegisterRequest request){
        return authenticationService.register(request);
    }

    @PostMapping("login")
    public ResponseEntity login (@RequestBody LoginRequest request){
        return authenticationService.login(request);
    }

    @GetMapping("me")
    public ResponseEntity<UserResponse> retrieveUser(){
        User user = userService.retrieveUserByContext();
        return  ResponseEntity.ok(userService.userResponse(user));
    }

    @Operation(
            responses = {
                    @ApiResponse(
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "User not Found",
                            responseCode = "404"
                    )
            }
    )
    @GetMapping("user/{id}")
    public ResponseEntity retrieveUserById(@PathVariable(name = "id") Integer userId){
        Optional<User> user = userService.retrieveUserById(userId);
        if(user.isPresent()){
            return ResponseEntity.ok(userService.userResponse(user.get()));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }

}

