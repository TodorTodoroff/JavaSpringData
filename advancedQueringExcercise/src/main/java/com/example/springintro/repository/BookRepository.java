package com.example.springintro.repository;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle
            (String author_firstName, String author_lastName);

    List<Book> findByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, int copies);

    List<Book> findByPriceLessThanOrPriceGreaterThan(BigDecimal lower, BigDecimal higher);

    List<Book> findByReleaseDateBeforeOrReleaseDateAfter(LocalDate from, LocalDate to);

    @Query("select b from Book b where lower(b.title) like lower(concat('%', ?1, '%'))")
    List<Book> findByTitleContaining(String nextLine);

    List<Book> findByAuthorLastNameStartingWith(String startWith);

    @Query("select b from Book b where LENGTH(b.title) > ?1")
    List<Book> findByTitleGreaterThan(int number);

    @Query("select b.author.firstName, b.author.lastName ,SUM(b.copies) as s from Book b GROUP BY b.author.id ORDER BY s DESC")
    List<String> findByAuthorFirstNameAndAuthorLastNameOrderBy();

    @Query("select b.title,b.editionType,b.ageRestriction,b.price from Book b where b.title = ?1")
    List<String> findByTitle(String nextLine);
}

