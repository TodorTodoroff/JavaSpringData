package com.example.advquerying.repositories;


import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo,Integer> {

    List<Shampoo> findBySizeOrderById(Size size);

    List<Shampoo> findBySizeOrLabelIdOrderByPriceAsc(Size size, Long label_id);

    List<Shampoo> findByPriceGreaterThanOrderByPriceDesc(BigDecimal price);

    int countByPriceLessThan(BigDecimal price);

    @Query("select s from Shampoo s inner join s.ingredients ingredients where ingredients.name in ?1 group by s.brand")
    List<Shampoo> findByIngredientsNameIn(List<String> names);

    @Query("SELECT s FROM Shampoo s" +
            " WHERE s.ingredients.size < :count")
    List<Shampoo>  findByIngredientCountLessThan(int count);
}
