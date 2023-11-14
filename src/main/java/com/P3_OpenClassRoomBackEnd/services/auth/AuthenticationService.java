package com.P3_OpenClassRoomBackEnd.services.auth;

import com.P3_OpenClassRoomBackEnd.configuration.JwtService;
import com.P3_OpenClassRoomBackEnd.models.User;
import com.P3_OpenClassRoomBackEnd.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.naming.AuthenticationException;
import java.net.URI;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public ResponseEntity register(RegisterRequest request) {

        Optional<User> userAlreadyExist = usersRepository.findByEmail(request.getEmail());
        if (userAlreadyExist.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already taken");
        }

        if(request.getEmail() == null || request.getPassword() == null || request.getName() == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Data is missing !");
        }

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .created_at(new Date())
                .build();

        usersRepository.save(user);

        String jwtToken = jwtService.generateToken(user);

        return ResponseEntity.created(
                URI.create("/api/auth/register"))
                        .body(
                                AuthenticationResponse
                                        .builder()
                                        .token(jwtToken)
                                        .build()
                        );

    }


    public ResponseEntity login(LoginRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );
            Optional<User> user = usersRepository.findByEmail(request.getEmail());
            String jwtToken = jwtService.generateToken(user.get());
                return ResponseEntity.ok(
                        AuthenticationResponse
                        .builder()
                        .token(jwtToken)
                        .build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Bad Credentials");
        }
    }

}
