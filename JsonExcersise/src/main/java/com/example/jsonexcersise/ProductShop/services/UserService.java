package com.example.jsonexcersise.ProductShop.services;

import com.example.jsonexcersise.ProductShop.entities.users.UserWithSoldProductDTO;

import java.util.List;

public interface UserService {



    List<UserWithSoldProductDTO> findAllUsersWithSoldProducts();
}
