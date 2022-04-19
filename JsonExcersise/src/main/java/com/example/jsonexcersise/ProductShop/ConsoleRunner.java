package com.example.jsonexcersise.ProductShop;

import com.example.jsonexcersise.ProductShop.entities.categories.CategoryStats;
import com.example.jsonexcersise.ProductShop.entities.products.ProductWithoutBuyerDTO;
import com.example.jsonexcersise.ProductShop.entities.users.UserWithSoldProductDTO;
import com.example.jsonexcersise.ProductShop.services.ProductService;
import com.example.jsonexcersise.ProductShop.services.SeedService;
import com.example.jsonexcersise.ProductShop.services.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ConsoleRunner implements CommandLineRunner {

    private final SeedService seedService;
    private final ProductService productService;
    private UserService userService;

    private final Gson gson;

    @Autowired
    public ConsoleRunner(SeedService seedService, ProductService productService, UserService userService) {
        this.seedService = seedService;
        this.productService = productService;
        this.userService = userService;

        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    @Override
    public void run(String... args) throws Exception {

       // printProductsInPriceRangeWithoutBuyers();

       // printUsersWithSoldProducts();

       // printCategoryStatistics();


        List<UserWithSoldProductDTO> userWithSoldProductsDto = this.userService.findAllUsersWithSoldProducts();
        String content = gson.toJson(userWithSoldProductsDto);

        System.out.println(content);


    }

    private void printCategoryStatistics() {
        List<CategoryStats> categoryStatistics = this.productService.getCategoryStatistics();

        String json = this.gson.toJson(categoryStatistics);
        System.out.println(json);
    }

    private void printUsersWithSoldProducts() {
        List<UserWithSoldProductDTO> usersWithSoldProducts = this.userService.findAllUsersWithSoldProducts();

        String json = this.gson.toJson(usersWithSoldProducts);
        System.out.println(json);
    }

    private void printProductsInPriceRangeWithoutBuyers() {
        List<ProductWithoutBuyerDTO> productsInPriceRangeForSell = this.productService.getProductsInPriceRangeForSell(500, 1000);

        String json = this.gson.toJson(productsInPriceRangeForSell);

        System.out.println(json);
    }
}
