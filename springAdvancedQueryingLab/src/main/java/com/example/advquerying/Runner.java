package com.example.advquerying;

import com.example.advquerying.repositories.ShampooRepository;
import com.example.advquerying.services.IngredientService;
import com.example.advquerying.services.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.math.BigDecimal;
import java.util.List;


@Component
public class Runner implements CommandLineRunner {

    private final ShampooRepository shampooRepository;
    private final ShampooService shampooService;
    private final IngredientService ingredientService;

    @Autowired
    public Runner(ShampooRepository shampooRepository, ShampooService shampooService, IngredientService ingredientService) {
        this.shampooRepository = shampooRepository;
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
    }

    @Override
    public void run(String... args) throws Exception {

//        this.shampooService.selectByPriceGreaterThanOrderByPriceDesc(new BigDecimal(5))
//                .forEach(System.out::println);

//        this.shampooService.selectByIngredientsCountLessThan(2)
//                .forEach(System.out::println);
        System.out.println(this.ingredientService.deleteByName("Apple"));
    }
}
