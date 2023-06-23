package com.shop.bookstore.controller.admin;

import com.shop.bookstore.convert.BookConvert;
import com.shop.bookstore.dto.BookDto;
import com.shop.bookstore.entity.BookEntity;
import com.shop.bookstore.entity.CategoryEntity;
import com.shop.bookstore.service.BookService;
import com.shop.bookstore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/book")
@CrossOrigin
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;


    @GetMapping("/")
    public List<BookDto> getAllBooks() {
        List<BookEntity> bookEntityListEntity = bookService.getAllBook();
        return bookEntityListEntity.stream().map(book -> BookConvert.getINSTANCE().toDto(book)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable String id) {
        BookEntity bookEntity = new BookEntity();
        bookEntity = bookService.getBookById(Integer.valueOf(id));
        if(Integer.valueOf(id) == 0) {
            return new BookDto();
        }
        BookDto bookDto =  BookConvert.toDto(bookEntity);
        return bookDto;
    }

    @GetMapping("/category/{cateId}")
    public List<BookDto> getBookByCategory(@PathVariable String cateId) {
        List<BookEntity> bookEntities = bookService.getByCategory(Integer.parseInt(cateId));
        return bookEntities.stream().map(book ->BookConvert.toDto(book)).collect(Collectors.toList());
    }

    @GetMapping("/title/{title}")
    public List<BookDto> getBookByTitle(@PathVariable String title) {
        return bookService.getByTitle(title).stream().map(book -> BookConvert.getINSTANCE().toDto(book)).collect(Collectors.toList());
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/save/{id}")
    public ResponseEntity<String> editBook(@PathVariable String id, @RequestBody BookDto bookDto) {
        CategoryEntity category = categoryService.getById(bookDto.getIdCategory()).get();
        BookEntity bookEntity = bookService.getBookById(Integer.valueOf(id));
        BookConvert.toEntity(bookDto, bookEntity, category);
        return bookService.addOrEdit(bookEntity);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/save/{id}")
    public ResponseEntity<String> addBook(@RequestBody BookDto bookDto, @PathVariable String id
                        ) throws IOException {

        CategoryEntity category = categoryService.getById(bookDto.getIdCategory()).get();
        BookEntity bookEntity = BookConvert.toEntity(bookDto, category);
        return bookService.addOrEdit(bookEntity);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable String id) {
        bookService.deleteBook(Integer.parseInt(id));
    }
}
