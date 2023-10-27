package com.P3_OpenClassRoomBackEnd.repository;
import com.P3_OpenClassRoomBackEnd.models.UsersModel;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


//microservice
@Repository
public interface UsersRepository extends JpaRepository<UsersModel, Integer>{
    public UsersModel save(UsersModel user) throws DataAccessException;

    public List<UsersModel> findAll();


    Optional<UsersModel> findByEmail(String email);
}
