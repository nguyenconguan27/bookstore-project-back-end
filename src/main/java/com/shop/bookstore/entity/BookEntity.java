package com.shop.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Nationalized;

import java.sql.Date;
import java.util.List;
import java.util.ArrayList;

@Entity
@Data
@Table(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "release_date", nullable = false)
    private Date releaseDate;

    @Column(name = "des")
    @Nationalized
    private String des;

    @Column(name = "pages", nullable = false)
    private int pages;

    @Column(name = "image", nullable = true)
    private String image;

    @Column(name = "sold", nullable = false)
    private int sold;

    @Column(name = "price", nullable = false)
    private int price;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ReviewEntity> reviewEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderDetailEntity> orderDetailEntityList;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    @JsonBackReference
    private CategoryEntity category;
}
