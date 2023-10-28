package com.P3_OpenClassRoomBackEnd.repository;
import com.P3_OpenClassRoomBackEnd.models.RentalsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


//microservice
@Repository
public interface RentalsRepository extends JpaRepository<RentalsModel, Integer>{
    public RentalsModel save(RentalsModel rentals);

    public  List<RentalsModel> findAll();

    public Optional<RentalsModel> findById(Integer id);

}
