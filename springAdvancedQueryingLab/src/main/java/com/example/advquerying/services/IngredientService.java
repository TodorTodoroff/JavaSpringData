package com.example.advquerying.services;

import com.example.advquerying.entities.Ingredient;

import java.util.List;

public interface IngredientService {
    List<Ingredient> selectByNameWhichStartWithLetter(String startingWith);

    List<Ingredient> selectInNames(List<String> names);

    int deleteByName(String apple);
}
