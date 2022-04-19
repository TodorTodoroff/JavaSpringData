package com.example.jsonexcersise.ProductShop.services.Impl;

import com.example.jsonexcersise.ProductShop.entities.users.User;
import com.example.jsonexcersise.ProductShop.entities.users.UserWithSoldProductDTO;
import com.example.jsonexcersise.ProductShop.repositories.UserRepository;
import com.example.jsonexcersise.ProductShop.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.mapper = new ModelMapper();
    }






    @Override
    public List<UserWithSoldProductDTO> findAllUsersWithSoldProducts() {

        return this.userRepository.findAllByUsersWithMoreThanOneSoldProductOrderByProductsSold().stream()
                .map(user -> mapper.map(user, UserWithSoldProductDTO.class)).collect(Collectors.toList());
    }
}
