package com.example.jsonexcersise.ProductShop.entities.users;

import com.example.jsonexcersise.ProductShop.entities.products.SoldProductDTO;
import com.google.gson.annotations.Expose;

import java.util.Set;

public class UserWithSoldProductDTO {

    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private Integer age;
    @Expose
    private Set<SoldProductDTO> soldProducts;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Set<SoldProductDTO> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(Set<SoldProductDTO> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
