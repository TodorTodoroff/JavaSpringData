package com.example.springdataexcercise.services;

import com.example.springdataexcercise.entities.Category;

import java.util.Set;

public interface CategoryService {
    Set<Category> getRandomCategory();
}
