package com.shop.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Nationalized;

import java.util.*;
import java.util.ArrayList;

@Data
@Entity
@Table(name = "category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    @Nationalized
    private String name;

    @OneToMany(mappedBy = "category")
    @JsonManagedReference
    private List<BookEntity> bookEntityList = new ArrayList<>();

    public int getId() {
        try {
            return id;
        }
        catch(NullPointerException e) {
            return 0;
        }
    }

    public String getName() {
        try {
            return name;
        }
        catch(NullPointerException e) {
            return "";
        }
    }
}
