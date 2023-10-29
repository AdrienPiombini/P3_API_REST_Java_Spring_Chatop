package com.P3_OpenClassRoomBackEnd.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="messages")
public class MessagesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String message;
    private Date created_at;
    private Date updated_at;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UsersModel usersModel;
    @ManyToOne
    @JoinColumn(name = "rental_id", referencedColumnName = "id")
    private RentalsModel rentalsModel;

}
