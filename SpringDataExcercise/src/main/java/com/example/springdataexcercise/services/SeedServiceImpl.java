package com.example.springdataexcercise.services;

import com.example.springdataexcercise.entities.*;
import com.example.springdataexcercise.repositories.AuthorRepository;
import com.example.springdataexcercise.repositories.BookRepository;
import com.example.springdataexcercise.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class SeedServiceImpl implements SeedService {
    private static final String RESOURCE_PATH = "src/main/resources/files";
    private static final String AUTHORS_FILE_NAME = RESOURCE_PATH + "/authors.txt";
    private static final String CATEGORIES_FILE_NAME = RESOURCE_PATH + "/categories.txt";
    private static final String BOOKS_FILE_NAME = RESOURCE_PATH + "/books.txt";

    @Autowired
    private AuthorRepository authorRepository;


    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private CategoryService categoryService;


    @Override
    public void seedAuthors() throws IOException {
        Files.readAllLines(Path.of(AUTHORS_FILE_NAME))
                .stream()
                .filter(s -> !s.isBlank())
                .map(s -> s.split("\\s+"))
                .map(name -> new Author(name[0], name[1]))
                .forEach(authorRepository::save);
    }

    @Override
    public void seedCategories() throws IOException {
        Files.readAllLines(Path.of(CATEGORIES_FILE_NAME))
                .stream()
                .filter(s -> !s.isBlank())
                .map(Category::new)
                .forEach(categoryRepository::save);
    }

    @Override
    public void seedBooks() throws IOException {

        Files.readAllLines(Path.of(BOOKS_FILE_NAME))
                .stream()
                .filter(s -> !s.isBlank())
                .map(this::getBookObject)
                .forEach(bookRepository::save);

    }

    private Book getBookObject(String s) {
        String[] bookParts = s.split("\\s+");
        int editionTypeIndex = Integer.parseInt(bookParts[0]);
        EditionType editionType = EditionType.values()[editionTypeIndex];

        LocalDate publishedDate = LocalDate.parse(bookParts[1], DateTimeFormatter.ofPattern("d/M/yyyy"));

        int copies = Integer.parseInt(bookParts[2]);
        BigDecimal price = new BigDecimal(bookParts[3]);
        int ageRestrictionIndex = Integer.parseInt(bookParts[4]);
        AgeRestriction ageRestriction = AgeRestriction.values()[ageRestrictionIndex];

        String title = Arrays.stream(bookParts).skip(5)
                .collect(Collectors.joining(" "));

        Author author = authorService.getRandomAuthor();
        Set<Category> categories = categoryService.getRandomCategory();

        return new Book(ageRestriction,copies,editionType,price,publishedDate,title,author,categories);
    }
}
