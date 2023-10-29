package com.P3_OpenClassRoomBackEnd.repository;

import com.P3_OpenClassRoomBackEnd.models.MessagesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessagesRepository extends JpaRepository<MessagesModel, Integer> {

    public MessagesModel save(MessagesModel messagesModel);

}
