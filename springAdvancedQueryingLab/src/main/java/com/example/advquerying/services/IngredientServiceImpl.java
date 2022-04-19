package com.example.advquerying.services;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.repositories.IngreadiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class IngredientServiceImpl implements IngredientService {


    @Autowired
    private IngreadiantRepository ingreadiantRepository;


    @Override
    public List<Ingredient> selectByNameWhichStartWithLetter(String startingWith) {
        return this.ingreadiantRepository.findByNameStartingWith(startingWith);
    }

    @Override
    public List<Ingredient> selectInNames(List<String> names) {
        return this.ingreadiantRepository.findByNameInOrderByPriceAsc(names);
    }

    @Override
    @Transactional
    public int deleteByName(String apple) {
       return this.ingreadiantRepository.deleteByName(apple);
    }
}
