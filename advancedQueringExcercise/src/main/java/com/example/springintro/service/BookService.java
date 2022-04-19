package com.example.springintro.service;

import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    List<String> findAllTitlesByAgeRestriction(String ageRestriction);

    List<String > findAllTitlesByGoledeEitionType(EditionType editionType, int copies);

    List<String > findAllTitlesWithPriceLessThanAndGreaterThan(BigDecimal lower, BigDecimal higher);

    List<String> findAllBooksThatAreNotReleasedInYear(int year);

    List<String> findAllTitlesByReleaseDateBefore(LocalDate before);

    List<String> findAllBooksContainingString(String nextLine);

    List<String> findAllTitlesWhichAuthorsLatstNameStartsWith(String startWith);

    int findAllTitlesWithLengthLongerThan(int number);

    List<String> findSumCountOfCopiesByAuthor();

    List<String> findBookDetailsByGivenTitle(String nextLine);
}
