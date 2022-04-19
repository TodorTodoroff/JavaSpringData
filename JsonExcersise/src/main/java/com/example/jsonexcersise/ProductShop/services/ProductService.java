package com.example.jsonexcersise.ProductShop.services;

import com.example.jsonexcersise.ProductShop.entities.categories.CategoryStats;
import com.example.jsonexcersise.ProductShop.entities.products.ProductWithoutBuyerDTO;


import java.util.List;

public interface ProductService {
    List<ProductWithoutBuyerDTO> getProductsInPriceRangeForSell(float from, float to);

    List<CategoryStats> getCategoryStatistics();
}
