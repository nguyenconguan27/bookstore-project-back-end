package com.shop.bookstore.reponsitory;

import com.shop.bookstore.entity.CartEntity;
import com.shop.bookstore.entity.OrderDetailEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.*;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, Integer> {
    List<OrderDetailEntity> getAllByCartAndStatus(CartEntity cartEntity, int status);

    List<OrderDetailEntity> findAllByCart_IdAndStatus(int cartId, int status);
}
