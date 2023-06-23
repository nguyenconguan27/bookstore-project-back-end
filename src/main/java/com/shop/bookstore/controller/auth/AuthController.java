package com.shop.bookstore.controller.auth;


import com.shop.bookstore.dto.AuthResponseDto;
import com.shop.bookstore.dto.LoginDto;
import com.shop.bookstore.dto.RegisterDto;
import com.shop.bookstore.service.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/auth")
@RestController
@CrossOrigin
public class AuthController {
    @Autowired
    private UserSevice userSevice;

    @PostMapping("/signup")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        return userSevice.register(registerDto);
    }


    @PostMapping("/login")
    public AuthResponseDto login(@RequestBody LoginDto loginDto){
        return userSevice.login(loginDto);
    }

}
