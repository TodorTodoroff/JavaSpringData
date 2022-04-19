package com.example.jsonexcersise.ProductShop.repositories;

import com.example.jsonexcersise.ProductShop.entities.categories.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
