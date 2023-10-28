package com.P3_OpenClassRoomBackEnd.mappers;

import com.P3_OpenClassRoomBackEnd.DTO.RentalsDao;
import com.P3_OpenClassRoomBackEnd.models.RentalsModel;
import com.P3_OpenClassRoomBackEnd.models.UsersModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class RentalsMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    public RentalsDao fromRentalsModel(RentalsModel rentalsModel){
        RentalsDao rentalsDao = modelMapper.map(rentalsModel, RentalsDao.class);
        rentalsDao.setOwner_id(rentalsModel.getId());
        return rentalsDao;
    }
    public RentalsModel fromRentalsDao(RentalsDao rentalsDao){
        return modelMapper.map(rentalsDao, RentalsModel.class);
    }
}
