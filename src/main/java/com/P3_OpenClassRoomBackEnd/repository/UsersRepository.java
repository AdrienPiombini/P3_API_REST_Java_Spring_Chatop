package com.P3_OpenClassRoomBackEnd.repository;
import com.P3_OpenClassRoomBackEnd.models.User;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UsersRepository extends JpaRepository<User, Integer>{
    public User save(User user) throws DataAccessException;

    public List<User> findAll();

    Optional<User> findByEmail(String email);

    Optional<User> findById(Integer userId);
}
