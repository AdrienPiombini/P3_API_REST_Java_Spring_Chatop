package com.P3_OpenClassRoomBackEnd.services.auth;

import com.P3_OpenClassRoomBackEnd.models.Role;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    private Role role = Role.USER;

}
