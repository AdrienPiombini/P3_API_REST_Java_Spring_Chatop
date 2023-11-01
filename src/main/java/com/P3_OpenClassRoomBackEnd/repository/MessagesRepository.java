package com.P3_OpenClassRoomBackEnd.repository;

import com.P3_OpenClassRoomBackEnd.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessagesRepository extends JpaRepository<Message, Integer> {

    public Message save(Message message);

}
