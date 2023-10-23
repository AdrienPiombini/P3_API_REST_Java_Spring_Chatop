package com.P3_OpenClassRoomBackEnd.Backend_Java_SpringP3.authTest;

import com.P3_OpenClassRoomBackEnd.service.auth.RegisterRequest;
import com.P3_OpenClassRoomBackEnd.service.auth.AuthenticationResponse;
import com.P3_OpenClassRoomBackEnd.models.UsersModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RegisterRequestTest {

    @Autowired
    RegisterRequest registerRequest;


}
