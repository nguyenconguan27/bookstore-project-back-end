package com.shop.bookstore.convert;

import com.shop.bookstore.dto.BookDto;
import com.shop.bookstore.entity.BookEntity;
import com.shop.bookstore.entity.CategoryEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class BookConvert {
    private static BookConvert INSTANCE;

    public static BookConvert getINSTANCE(){
        if (INSTANCE == null)
            INSTANCE = new BookConvert();
        return INSTANCE;
    }


    public static BookDto toDto(BookEntity bookEntity) {
        BookDto bookDto = new BookDto();
        bookDto.setId(bookEntity.getId());
        bookDto.setTitle(bookEntity.getTitle());
        bookDto.setDes(bookEntity.getDes());
        bookDto.setAuthor(bookEntity.getAuthor());
        bookDto.setImage(bookEntity.getImage());
        bookDto.setPages(bookEntity.getPages());
        bookDto.setPrice(bookEntity.getPrice());
        bookDto.setSold(bookEntity.getSold());
        bookDto.setReleaseDate(bookEntity.getReleaseDate());
        bookDto.setIdCategory(bookEntity.getCategory().getId());
        bookDto.setNameCategory(bookEntity.getCategory().getName());
        return bookDto;
    }

    public static BookEntity toEntity(BookDto bookDto, CategoryEntity category) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setTitle(bookDto.getTitle());
        bookEntity.setDes(bookDto.getDes());
        bookEntity.setAuthor(bookDto.getAuthor());
        bookEntity.setCategory(category);
        bookEntity.setImage(bookDto.getImage());
        bookEntity.setPages(bookDto.getPages());
        bookEntity.setSold(bookDto.getSold());
        bookEntity.setPrice(bookDto.getPrice());
        bookEntity.setReleaseDate(bookDto.getReleaseDate());
        bookEntity.setCategory(category);
        return bookEntity;
    }

    public static void toEntity(BookDto bookDto, BookEntity bookEntity, CategoryEntity category) {
        bookEntity.setId(bookDto.getId());
        bookEntity.setTitle(bookDto.getTitle());
        bookEntity.setDes(bookDto.getDes());
        bookEntity.setAuthor(bookDto.getAuthor());
        bookEntity.setCategory(category);
        bookEntity.setImage(bookDto.getImage());
        bookEntity.setPages(bookDto.getPages());
        bookEntity.setPrice(bookDto.getPrice());
        bookEntity.setReleaseDate(bookDto.getReleaseDate());
    }
}
