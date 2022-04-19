package com.example.springdataexcercise.repositories;

import com.example.springdataexcercise.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    List<Book> findByReleaseDateAfter(LocalDate releaseDate);

    List<Book> findByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(String george, String powell);
}
