package com.example.springautomappingex;


import com.example.springautomappingex.exceptions.UserNotLoggedInException;
import com.example.springautomappingex.exceptions.ValidationException;
import com.example.springautomappingex.services.ExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;


@Component
public class ConsoleRunner implements CommandLineRunner {

    private final ExecutorService executorService;

    @Autowired
    public ConsoleRunner(ExecutorService executorService) {
        this.executorService = executorService;
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        String commandData = scanner.nextLine();

        String result;
        try {
            result = executorService.execute(command, commandData);
        } catch (ValidationException | UserNotLoggedInException ex) {
            result = ex.getMessage();
        }

        System.out.println(result);
    }
}
