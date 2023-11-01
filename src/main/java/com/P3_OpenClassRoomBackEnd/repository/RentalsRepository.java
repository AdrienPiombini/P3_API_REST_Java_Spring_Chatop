package com.P3_OpenClassRoomBackEnd.repository;
import com.P3_OpenClassRoomBackEnd.models.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


//microservice
@Repository
public interface RentalsRepository extends JpaRepository<Rental, Integer>{
    public Rental save(Rental rentals);

    public  List<Rental> findAll();

    public Optional<Rental> findById(Integer id);

}
