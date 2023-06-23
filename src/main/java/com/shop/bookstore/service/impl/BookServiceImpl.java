package com.shop.bookstore.service.impl;

import com.shop.bookstore.entity.BookEntity;
import com.shop.bookstore.reponsitory.BookRepository;
import com.shop.bookstore.service.BookService;
import com.shop.bookstore.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<BookEntity> getAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public BookEntity getBookById(int id) {

        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public ResponseEntity<String> addOrEdit(BookEntity bookEntity) {
        if(!bookRepository.existsById(bookEntity.getId()) && bookRepository.existsByTitleAndAuthor(bookEntity.getTitle(), bookEntity.getAuthor())) {
            return new ResponseEntity<>("Sách đã tồn tại!", HttpStatus.BAD_REQUEST);
        }
        bookRepository.save(bookEntity);
        return new ResponseEntity<>("Cập nhập sách thành công!", HttpStatus.OK);
    }

    @Override
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<BookEntity> getByCategory(int cateId) {
        return bookRepository.findByCategory(cateId);
    }

    @Override
    public List<BookEntity> getByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    @Override
    public String saveFile(MultipartFile file) throws IOException {
        String uploadDir = "image/book/";
        Path pathFile = FileUploadUtil.save(file, uploadDir);
        String pathStr = pathFile.toString().replace("\\", "/");
//		String pathStr = pathFile.toString();
        return pathStr;
    }
}
