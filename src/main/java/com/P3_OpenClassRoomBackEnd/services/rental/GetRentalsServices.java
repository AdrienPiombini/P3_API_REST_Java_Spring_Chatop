package com.P3_OpenClassRoomBackEnd.services.rental;


import com.P3_OpenClassRoomBackEnd.DTO.RentalsDao;
import com.P3_OpenClassRoomBackEnd.configuration.JwtService;
import com.P3_OpenClassRoomBackEnd.mappers.RentalsMapper;
import com.P3_OpenClassRoomBackEnd.models.RentalsModel;
import com.P3_OpenClassRoomBackEnd.repository.RentalsRepository;
import com.P3_OpenClassRoomBackEnd.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class GetRentalsServices {

    private final RentalsRepository rentalsRepository;

    private final RentalsMapper rentalsMapper;

    public RentalsModel getOneRentalModel(Integer rentalId) {
        var rental =  rentalsRepository.findById(rentalId);
        return rental.get();
    }

    public RentalsDao getOneRentalDao(RentalsModel rentalsModel) {
        return rentalsMapper.fromRentalsModel(rentalsModel);
    }

    public List<RentalsDao> getAllRentalsDao(){
        var rentalsModels = rentalsRepository.findAll();
        List<RentalsDao> rentalsDao = rentalsModels.stream().map(rentalsModel -> rentalsMapper.fromRentalsModel(rentalsModel)).collect(Collectors.toList());
        return rentalsDao;
    }



}
