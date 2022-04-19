package com.example.springautomappingobjects.services;

import com.example.springautomappingobjects.entities.Employee;
import com.example.springautomappingobjects.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Optional<Employee> findOneById(int id) {
        return this.employeeRepository.findById(id);
    }

    @Override
    public void save(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findEmployeesBornBefore(int year) {
        LocalDate beforeYear = LocalDate.of(year,1,1);
        return this.employeeRepository.findByBirthdayBeforeOrderBySalaryDesc(beforeYear);
    }
}
