package com.P3_OpenClassRoomBackEnd.mappers;

import com.P3_OpenClassRoomBackEnd.models.Rental;
import com.P3_OpenClassRoomBackEnd.services.rental.RentalResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class RentalsMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    public RentalResponse fromRentalsModel(Rental rental){
        RentalResponse rentalsDao = modelMapper.map(rental, RentalResponse.class);
        rentalsDao.setOwner_id(rental.getId());
        return rentalsDao;
    }
}
