package com.P3_OpenClassRoomBackEnd.services.rental;

import com.P3_OpenClassRoomBackEnd.models.RentalsModel;
import com.P3_OpenClassRoomBackEnd.repository.RentalsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class UpdateRentalService {

    private final RentalsRepository rentalsRepository;
    private final GetRentalsServices getRentalsServices;

    public void updateRental(RentalsModel changes, Integer rentalId) {

        RentalsModel rentalsModel = getRentalsServices.getOneRentalModel(rentalId);

        rentalsModel.setName(changes.getName());
        rentalsModel.setSurface(changes.getSurface());
        rentalsModel.setPrice(changes.getPrice());
        rentalsModel.setPicture(changes.getPicture());
        rentalsModel.setDescription(changes.getDescription());
        rentalsModel.setUpdated_at(new Date());

        rentalsRepository.save(rentalsModel);
    }
}
