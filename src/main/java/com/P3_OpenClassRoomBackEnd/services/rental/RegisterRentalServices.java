package com.P3_OpenClassRoomBackEnd.services.rental;

import com.P3_OpenClassRoomBackEnd.models.RentalsModel;
import com.P3_OpenClassRoomBackEnd.models.UsersModel;
import com.P3_OpenClassRoomBackEnd.repository.RentalsRepository;
import com.P3_OpenClassRoomBackEnd.services.auth.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class RegisterRentalServices {
    private final RentalsRepository rentalsRepository;
    private final AuthenticationService authenticationService;
    public void registerRental(RentalsModel rentalsModel, String token){
        UsersModel usersModel = authenticationService.retrieveUserByToken(token);
        rentalsModel.setUsersModel(usersModel);
        rentalsModel.setCreated_at(new Date());
        rentalsRepository.save(rentalsModel);
    }

}
