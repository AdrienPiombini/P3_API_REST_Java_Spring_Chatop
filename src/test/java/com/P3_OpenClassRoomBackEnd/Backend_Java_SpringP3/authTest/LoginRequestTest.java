package com.P3_OpenClassRoomBackEnd.Backend_Java_SpringP3.authTest;

import com.P3_OpenClassRoomBackEnd.service.auth.LoginRequest;
import com.P3_OpenClassRoomBackEnd.service.auth.AuthenticationResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class LoginRequestTest {

    @Autowired
    LoginRequest loginRequest;



}
