package com.shop.bookstore.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.*;

@Data
@Setter
@NoArgsConstructor
public class UserDto {
    private Integer id;
    private String username;
    private String fullname;
    private String number;
    private String address;
    private Integer cartId;
    private Collection<? extends GrantedAuthority> roles;

    public UserDto(Integer id, String username, String fullname, String number, String address, Collection<? extends GrantedAuthority> roles, Integer cartId) {
        this.id = id;
        this.username = username;
        this.fullname = fullname;
        this.number = number;
        this.roles = roles;
        this.address = address;
        this.cartId = cartId;
    }
}
