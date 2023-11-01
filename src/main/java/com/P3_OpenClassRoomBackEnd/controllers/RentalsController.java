package com.P3_OpenClassRoomBackEnd.controllers;


import com.P3_OpenClassRoomBackEnd.models.Rental;
import com.P3_OpenClassRoomBackEnd.services.rental.RentalRequest;
import com.P3_OpenClassRoomBackEnd.services.rental.RentalResponse;
import com.P3_OpenClassRoomBackEnd.services.rental.RentalServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="rentals")
@RequiredArgsConstructor
public class RentalsController {

    private final RentalServices rentalServices;

    @PostMapping
    public void savingRental(@ModelAttribute RentalRequest rental){
        rentalServices.registerRental(rental);
    }

    @GetMapping
    public List<RentalResponse> retrieveAll(){
        return rentalServices.getAllRentalsDao();
    }

    @GetMapping("/{id}")
    public RentalResponse retrieveOneRental(@PathVariable(name = "id") Integer rentalId){
        Rental rental = rentalServices.getOneRentalModel(rentalId);
        return rentalServices.getOneRentalDao(rental);
    }

    @PutMapping("/{id}")
    public void updateRental(@ModelAttribute RentalRequest request , @PathVariable(name = "id") Integer rentalId){
        rentalServices.updateRental(request, rentalId);
    }
}
