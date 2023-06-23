package com.shop.bookstore.reponsitory;

import com.shop.bookstore.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer> {
    @Query(value = "SELECT * FROM book WHERE idcategory = ?1", nativeQuery = true)
    List<BookEntity> findByCategory(int cateId);

    List<BookEntity> findByTitle(String title);

    Boolean existsByTitleAndAuthor(String title, String author);



}
