package com.P3_OpenClassRoomBackEnd.controllers;


import com.P3_OpenClassRoomBackEnd.DTO.RentalsDao;
import com.P3_OpenClassRoomBackEnd.models.RentalsModel;
import com.P3_OpenClassRoomBackEnd.models.UsersModel;
import com.P3_OpenClassRoomBackEnd.services.rental.RegisterRentalServices;
import com.P3_OpenClassRoomBackEnd.services.rental.GetRentalsServices;
import com.P3_OpenClassRoomBackEnd.services.rental.UpdateRentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="rentals")
@RequiredArgsConstructor
public class RentalsController {

    private final GetRentalsServices rentalsServices;
    private final RegisterRentalServices registerRentalServices;
    private final UpdateRentalService updateRentalService;

    @PostMapping
    public void savingRental(
            @RequestBody RentalsModel rentalsModel,
            @RequestHeader("Authorization") String token)
    {
        registerRentalServices.registerRental(rentalsModel, token);
    }

    @GetMapping
    public List<RentalsDao> retrieveAll(){
        return rentalsServices.getAllRentalsDao();
    }

    @GetMapping("/{id}")
    public RentalsDao retrieveOneRental(@PathVariable(name = "id") Integer rentalId){
        RentalsModel rentalsModel = rentalsServices.getOneRentalModel(rentalId);
        return rentalsServices.getOneRentalDao(rentalsModel);
    }

    @PutMapping("/{id}")
    public void updateRental(@RequestBody RentalsModel changes,@PathVariable(name = "id") Integer rentalId){
        updateRentalService.updateRental(changes, rentalId);
    }
}
