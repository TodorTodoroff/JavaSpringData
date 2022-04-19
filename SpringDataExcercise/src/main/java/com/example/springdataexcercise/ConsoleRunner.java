package com.example.springdataexcercise;

import com.example.springdataexcercise.entities.Author;
import com.example.springdataexcercise.entities.Book;
import com.example.springdataexcercise.repositories.AuthorRepository;
import com.example.springdataexcercise.repositories.BookRepository;
import com.example.springdataexcercise.services.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Component
public class ConsoleRunner implements CommandLineRunner {


    private final SeedService seedServices;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public ConsoleRunner(SeedService seedServices, BookRepository bookRepository, AuthorRepository authorRepository) {
        this.seedServices = seedServices;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//        this.seedServices.seedAuthors();
//        this.seedServices.seedCategories();
//        this.seedServices.seedAll();

//        this.booksAfter2000();
//        this.authorsWithBooksBefore1990()
//        this.authorsWithBooksCount();
//        this.booksWithAuthorGP();
    }

    private void booksWithAuthorGP() {
        List<Book> books = this.bookRepository
                .findByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc("George", "Powell");

        books.forEach(b -> System.out.println(b.getTitle() + " " + b.getReleaseDate() + " " + b.getCopies()));
    }

    private void authorsWithBooksCount() {
        List<Author> authors = this.authorRepository.findAll();

        authors.stream()
                .sorted((l, r) -> r.getBooks().size() - l.getBooks().size())
                .forEach(a -> System.out.println(a.getFirstName()
                        + " " + a.getLastName() + " -> " + a.getBooks().size()));
    }

    private void authorsWithBooksBefore1990() {
        LocalDate year1990 = LocalDate.of(1990, 1, 1);

        List<Author> authors = this.authorRepository.findDistinctByBooksReleaseDateBefore(year1990);
        authors.forEach(a -> System.out.println(a.getFirstName() + " " + a.getLastName()));
    }

    private void booksAfter2000() {
        LocalDate year2000 = LocalDate.of(2000, 1, 1);
        List<Book> books = this.bookRepository.findByReleaseDateAfter(year2000);
        books.forEach(b -> System.out.println(b.getTitle() + " " + b.getReleaseDate()));
    }
}
