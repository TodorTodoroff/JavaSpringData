package com.example.advquerying.services;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import com.example.advquerying.repositories.ShampooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ShampooServiceImpl implements ShampooService {

    @Autowired
    private  ShampooRepository shampooRepository;

    @Override
    public List<Shampoo> selectBySize(Size size) {
        return this.shampooRepository.findBySizeOrderById(size);
    }

    @Override
    public List<Shampoo> selectBySizeOrLabelId(Size size, long labelId) {
        return this.shampooRepository.findBySizeOrLabelIdOrderByPriceAsc(size,  labelId);
    }

    @Override
    public List<Shampoo> selectByPriceGreaterThanOrderByPriceDesc(BigDecimal price) {
        return this.shampooRepository.findByPriceGreaterThanOrderByPriceDesc(price);
    }

    @Override
    public int countShampooByPriceLowerThan(BigDecimal price) {
        return this.shampooRepository.countByPriceLessThan(price);
    }

    @Override
    public List<Shampoo> selectByIngredients(List<String> names) {
        return this.shampooRepository.findByIngredientsNameIn(names);
    }

    @Override
    public List<Shampoo> selectByIngredientsCountLessThan(int count) {
        return this.shampooRepository. findByIngredientCountLessThan(count);
    }

}
