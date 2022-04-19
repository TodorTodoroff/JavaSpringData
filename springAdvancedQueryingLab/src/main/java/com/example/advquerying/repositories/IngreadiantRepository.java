package com.example.advquerying.repositories;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.services.IngredientService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngreadiantRepository extends JpaRepository<Ingredient, Integer> {
    List<Ingredient> findByNameStartingWith(String startingWith);

    List<Ingredient> findByNameInOrderByPriceAsc(List<String> names);

    int deleteByName(String apple);
}
