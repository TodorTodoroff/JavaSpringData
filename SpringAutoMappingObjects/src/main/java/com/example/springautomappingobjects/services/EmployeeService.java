package com.example.springautomappingobjects.services;

import com.example.springautomappingobjects.entities.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Optional<Employee> findOneById(int id);

    void save(Employee employee);

    List<Employee> findEmployeesBornBefore(int year);
}
