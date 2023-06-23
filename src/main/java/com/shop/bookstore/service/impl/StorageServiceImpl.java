package com.shop.bookstore.service.impl;

import com.shop.bookstore.service.StorageService;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;

@Service
public class StorageServiceImpl implements StorageService {
    @Override
    public ByteArrayResource readContentFile(String photo) {
        if(!photo.equals("") || photo != null) {
            try {
                Path fileName = Paths.get("image/book/", photo);
                byte[] buffer = Files.readAllBytes(fileName);
                ByteArrayResource byteArrayResource = new ByteArrayResource(buffer);
                return byteArrayResource;
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
