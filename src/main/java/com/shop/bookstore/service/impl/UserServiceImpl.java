package com.shop.bookstore.service.impl;

import com.shop.bookstore.dto.AuthResponseDto;
import com.shop.bookstore.dto.LoginDto;
import com.shop.bookstore.dto.RegisterDto;
import com.shop.bookstore.entity.CartEntity;
import com.shop.bookstore.entity.RoleEntity;
import com.shop.bookstore.entity.UserEntity;
import com.shop.bookstore.reponsitory.CartRepository;
import com.shop.bookstore.reponsitory.RoleRepository;
import com.shop.bookstore.reponsitory.UserRepository;
import com.shop.bookstore.security.JWTGenerator;
import com.shop.bookstore.security.UserPrinciple;
import com.shop.bookstore.service.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserSevice {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JWTGenerator jwtGenerator;


    @Override
    public Optional<UserEntity> getUserById(int id) {
        return userRepository.findById(id);
    }



    @Override
    public ResponseEntity<String> register(RegisterDto registerDto) {
        if (userRepository.existsByUsername(registerDto.getUsername())) {
            return new ResponseEntity<>("Tên đăng nhập đã tồn tại!", HttpStatus.BAD_REQUEST);
        }
        if (userRepository.existsByEmail(registerDto.getEmail())) {
            return new ResponseEntity<>("Email đã được đăng ký tài khoản!", HttpStatus.BAD_REQUEST);
        }
        CartEntity cart = new CartEntity();

        UserEntity user = new UserEntity();
        user.setUsername(registerDto.getUsername());
        user.setAddress(registerDto.getAddress());
        user.setFullName(registerDto.getFullname());
        user.setNumber(registerDto.getNumber());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode((registerDto.getPassword())));
        RoleEntity roles = roleRepository.findByName("USER").get();
        user.setRoles(Collections.singletonList(roles));
        userRepository.save(user);
        cart.setUser(user);
        cartRepository.save(cart);
        return new ResponseEntity<>("Đăng ký tài khoản thành công!", HttpStatus.OK);
    }

    @Override
    public AuthResponseDto login(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getUsername(),
                        loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
//        AuthResponseDto authResponseDto = new AuthResponseDto(principle.getId());

        return new AuthResponseDto(userPrinciple, token);
    }


}
