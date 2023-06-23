package com.shop.bookstore.controller.admin;

import java.io.IOException;
import java.nio.file.NoSuchFileException;

import com.shop.bookstore.service.BookService;
import com.shop.bookstore.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequestMapping("/book/file")
@CrossOrigin

public class UploadFielController {
    @Autowired
    private BookService bookService;

    @Autowired
    private StorageService storeService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/upload")
    public String uploadFile(@RequestParam(name = "image") MultipartFile image) throws IOException {
        String pathStr = bookService.saveFile(image);
        // chuyển thành đường dẫn tới ảnh trong thư mục
        String urlImage = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(pathStr)
                .toUriString();
        return pathStr.substring(pathStr.lastIndexOf("/")+1);
    }
    @GetMapping("/{photo}")
    public ResponseEntity<ByteArrayResource> getImage(@PathVariable("photo") String photo) {
        ByteArrayResource byteArrayResource = storeService.readContentFile(photo);
        if(byteArrayResource == null) {
            return ResponseEntity.badRequest().build();
        }
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_PNG)
                    .body(byteArrayResource);

    }
}
