package com.shop.bookstore.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shop.bookstore.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.Collection;
import java.util.stream.Collectors;

public class UserPrinciple implements UserDetails {

    private Integer id;
    private String username;
    private String fullname;
    private String number;
    private String address;
    private Integer cartId;
    private Collection<? extends GrantedAuthority> roles;
    @JsonIgnore
    private String password;

    public static UserPrinciple build(UserEntity user) {
            List<GrantedAuthority> authorities = user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
            return new UserPrinciple(user.getId(), user.getUsername(), user.getFullName(), user.getNumber(), user.getAddress(), authorities, user.getCartEntity().getId(),user.getPassword());
    }

    public UserPrinciple(Integer id, String username, String fullname, String number, String address, Collection<? extends GrantedAuthority> roles, Integer cartId, String password) {
        this.id = id;
        this.username = username;
        this.fullname = fullname;
        this.number = number;
        this.address = address;
        this.roles = roles;
        this.cartId = cartId;
        this.password = password;
    }

    public Collection<? extends GrantedAuthority> getRoles() {
        return roles;
    }
    public Integer getCartId() {
        return cartId;
    }

    public Integer getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public String getNumber() {
        return number;
    }

    public String getAddress() {
        return address;
    }

    @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
