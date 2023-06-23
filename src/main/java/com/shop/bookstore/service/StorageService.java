package com.shop.bookstore.service;

import org.springframework.core.io.ByteArrayResource;

public interface StorageService {
    ByteArrayResource readContentFile(String photo);
}
