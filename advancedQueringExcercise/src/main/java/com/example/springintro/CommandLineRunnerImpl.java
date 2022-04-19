package com.example.springintro;

import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

        //printAllBooksAfterYear(2000);
//        printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(1990);
//        printAllAuthorsAndNumberOfTheirBooks();
//        pritnALlBooksByAuthorNameOrderByReleaseDate("George", "Powell");
//        printAllTitlesByAgeRestriction();
//        prinAllTitlesOfGoldenEditionBooksWithLessCopies(EditionType.valueOf("GOLD"), 5000);
//        printAllTitlesAndPricesOfBooksWithPriceLowerThan5AndHigherThan40();
//        printAllBooksWhichAreNotRealeasedInYear(2000);

//        printAllTitlesBeforeGivenDate();

//        printAllAuthorsByFirstNameEndWith(new Scanner(System.in).nextLine());
//        printAllBooksContainingGivenStringRegardlessOfTheCasing(new Scanner(System.in).nextLine());
//        printAllTitlesOfBooksWhichAuthorsLastNameStartsWith(new Scanner(System.in).nextLine())  ;
//        printAllTitlesLongerThanGivenNumber(Integer.parseInt(new Scanner(System.in).nextLine()));
        //     printSumOfTheCountOfCopiesByAuthor();
        printBookDetailsByGivenTitle(new Scanner(System.in).nextLine());
    }

    private void printBookDetailsByGivenTitle(String nextLine) {
        this.bookService.findBookDetailsByGivenTitle(nextLine)
                .forEach(entry -> {
                    System.out.println(entry.replaceAll(",", " "));
                });
    }

    private void printSumOfTheCountOfCopiesByAuthor() {
        this.bookService.findSumCountOfCopiesByAuthor()
                .forEach(entry -> {
                    System.out.println(entry.replaceAll(",", " "));
                });

    }

    private void printAllTitlesLongerThanGivenNumber(int number) {
        System.out.println(this.bookService.findAllTitlesWithLengthLongerThan(number));
    }

    private void printAllTitlesOfBooksWhichAuthorsLastNameStartsWith(String startWith) {
        this.bookService.findAllTitlesWhichAuthorsLatstNameStartsWith(startWith)
                .forEach(System.out::println);
    }

    private void printAllBooksContainingGivenStringRegardlessOfTheCasing(String nextLine) {
        this.bookService.findAllBooksContainingString(nextLine)
                .forEach(System.out::println);

    }

    private void printAllAuthorsByFirstNameEndWith(String endWith) {
        this.authorService.findAllByFirstNameEndWith(endWith)
                .forEach(System.out::println);

    }

    private void printAllTitlesBeforeGivenDate() {
        String date = new Scanner(System.in).nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate before = LocalDate.parse(date, formatter);

        this.bookService.findAllTitlesByReleaseDateBefore(before)
                .forEach(System.out::println);

    }

    private void printAllBooksWhichAreNotRealeasedInYear(int year) {
        this.bookService
                .findAllBooksThatAreNotReleasedInYear(year)
                .forEach(System.out::println);

    }

    private void printAllTitlesAndPricesOfBooksWithPriceLowerThan5AndHigherThan40() {
        this.bookService
                .findAllTitlesWithPriceLessThanAndGreaterThan(new BigDecimal(5), new BigDecimal(40))
                .forEach(System.out::println);

    }

    private void prinAllTitlesOfGoldenEditionBooksWithLessCopies(EditionType type, int copies) {
        this.bookService.findAllTitlesByGoledeEitionType(type, copies)
                .forEach(System.out::println);
    }

    private void printAllTitlesByAgeRestriction() {
        this.bookService
                .findAllTitlesByAgeRestriction(new Scanner(System.in).nextLine())
                .forEach(System.out::println);
    }

    private void pritnALlBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
