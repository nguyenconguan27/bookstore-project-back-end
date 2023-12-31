package com.shop.bookstore.reponsitory;

import com.shop.bookstore.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
    @Query(value = "SELECT * FROM orders WHERE user_id = ?1", nativeQuery = true)
    List<OrderEntity> findAllByUser(int userId);
}
