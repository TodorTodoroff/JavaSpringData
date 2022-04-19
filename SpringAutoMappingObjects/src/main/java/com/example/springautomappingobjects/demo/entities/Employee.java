package com.example.springautomappingobjects.demo.entities;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private BigDecimal salary;
    private LocalDate birthDate;
    private Address address;
    private boolean onVacation;
    private Employee manager;
    private Set<Employee> subordinates;


    public Employee(String firstName, String lastName, BigDecimal salary, LocalDate birthDate, Address address, boolean onVacation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.birthDate = birthDate;
        this.address = address;
        this.onVacation = onVacation;
        this.subordinates = new HashSet<>();
    }

    public void addEmployee(Employee employee){
        this.subordinates.add(employee);
    }

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

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Employee> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(Set<Employee> subordinates) {
        this.subordinates = subordinates;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public boolean isOnVacation() {
        return onVacation;
    }

    public void setOnVacation(boolean onVacation) {
        this.onVacation = onVacation;
    }
}
