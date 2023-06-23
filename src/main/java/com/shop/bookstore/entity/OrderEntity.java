package com.shop.bookstore.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;
import java.util.ArrayList;
import java.sql.Date;


@Data
@Entity
@Table(name = "orders")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@JsonIdentityReference(alwaysAsId=true)
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "is_confirmed", nullable = false)
    private int isConfirmed;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "price", nullable = false)
    private int price;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<OrderDetailEntity> orderDetailEntityList = new ArrayList<>();

}
