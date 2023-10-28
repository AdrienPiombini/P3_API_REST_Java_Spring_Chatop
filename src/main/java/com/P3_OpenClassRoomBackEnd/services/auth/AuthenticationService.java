package com.P3_OpenClassRoomBackEnd.services.auth;

import com.P3_OpenClassRoomBackEnd.mappers.UsersMapper;
import com.P3_OpenClassRoomBackEnd.configuration.JwtService;
import com.P3_OpenClassRoomBackEnd.models.UsersModel;
import com.P3_OpenClassRoomBackEnd.DTO.UsersDao;
import com.P3_OpenClassRoomBackEnd.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UsersMapper usersMapper;

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = UsersModel.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();

        usersRepository.save(user);

        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build();
    }
    public AuthenticationResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var  user = usersRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public UsersModel retrieveUser(String token){
        String jwt = token.substring(7);
        String email = jwtService.extractUsername(jwt);
        var usersModels = usersRepository.findByEmail(email);
        return usersModels.get();
    }

    public UsersDao retrieveUserDao(UsersModel usersModel) {
        return usersMapper.fromUserModel(usersModel);
    }


}
