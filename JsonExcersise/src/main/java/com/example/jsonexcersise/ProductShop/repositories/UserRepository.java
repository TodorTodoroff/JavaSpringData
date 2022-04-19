package com.example.jsonexcersise.ProductShop.repositories;


import com.example.jsonexcersise.ProductShop.entities.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

@Query("SELECT u FROM User u " +
        "JOIN u.sellingItems p " +
        "WHERE p.buyer IS NOT NULL ")
    List<User> findAllByWithSoldProducts();



    @Query("SELECT DISTINCT  u FROM User u JOIN Product p ON u.id = p.seller.id " +
            "WHERE p.buyer.id IS NOT NULL AND u.sellingItems.size > 0 " +
            "ORDER BY u.sellingItems.size desc ,u.lastName")
    List<User> findAllByUsersWithMoreThanOneSoldProductOrderByProductsSold();
}
