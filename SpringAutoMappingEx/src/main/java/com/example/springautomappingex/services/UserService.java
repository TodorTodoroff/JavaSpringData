package com.example.springautomappingex.services;

import com.example.springautomappingex.entites.users.LoginDTO;
import com.example.springautomappingex.entites.users.RegisterDTO;
import com.example.springautomappingex.entites.users.User;

import java.util.Optional;

public interface UserService {
    User register(RegisterDTO registerData);

    Optional<User> login(LoginDTO loginData);

    User getLoggedUser();

    void logout();
}
