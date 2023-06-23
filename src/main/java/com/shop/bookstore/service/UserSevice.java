package com.shop.bookstore.service;

import com.shop.bookstore.dto.AuthResponseDto;
import com.shop.bookstore.dto.LoginDto;
import com.shop.bookstore.dto.RegisterDto;
import com.shop.bookstore.entity.UserEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserSevice {

    Optional<UserEntity> getUserById(int id);

    ResponseEntity<String> register(RegisterDto registerDto);

    AuthResponseDto login(LoginDto loginDto);


}
