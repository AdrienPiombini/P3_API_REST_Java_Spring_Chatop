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
@Table(name="rentals")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Float surface;
    private Float price;
    private String picture;
    @Column(length = 1000)
    private String description;
    private Date created_at;
    private Date updated_at;
    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private User user;
}