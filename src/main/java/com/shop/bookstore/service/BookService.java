package com.shop.bookstore.service;

import com.shop.bookstore.entity.BookEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;
public interface BookService {
    List<BookEntity> getAllBook();

    BookEntity getBookById(int id);

    ResponseEntity<String> addOrEdit(BookEntity bookEntity);

    void deleteBook(int id);

    List<BookEntity> getByCategory(int cateId);

    List<BookEntity> getByTitle(String title);

    String saveFile(MultipartFile file) throws IOException;
}
