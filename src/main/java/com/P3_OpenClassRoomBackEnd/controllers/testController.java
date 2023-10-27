package com.P3_OpenClassRoomBackEnd.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class testController {
    @GetMapping("test")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Secured endpoint");
    }
}
