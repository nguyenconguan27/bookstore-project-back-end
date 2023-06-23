package com.shop.bookstore.dto;

import com.shop.bookstore.security.UserPrinciple;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponseDto{
    private Integer id;
    private String username;
    private String fullname;
    private String number;
    private String address;
    private Integer cartId;
    private Collection<? extends GrantedAuthority> roles;
    private String accessToken;
    public AuthResponseDto(UserPrinciple userPrinciple, String accessToken) {
        this.accessToken = accessToken;
        this.id = userPrinciple.getId();
        this.username = userPrinciple.getUsername();
        this.fullname = userPrinciple.getFullname();
        this.number = userPrinciple.getNumber();
        this.address = userPrinciple.getAddress();
        this.roles = userPrinciple.getRoles();
        this.cartId = userPrinciple.getCartId();
    }
}
