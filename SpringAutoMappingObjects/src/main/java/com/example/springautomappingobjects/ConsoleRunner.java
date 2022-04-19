package com.example.springautomappingobjects;

import com.example.springautomappingobjects.entities.Employee;
import com.example.springautomappingobjects.entities.dto.EmployeeSpringDto;
import com.example.springautomappingobjects.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private EmployeeService employeeService;

    @Autowired
    public ConsoleRunner(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {
        //    this.persist();

        List<Employee> manager = this.employeeService.findEmployeesBornBefore(1990);

        ModelMapper mapper = new ModelMapper();

        manager
                .stream()
                .map(e -> mapper.map(e, EmployeeSpringDto.class))
                .forEach(System.out::println);
    }


    private void persist() {
        Employee manager = new Employee(
                "MR"
                , "manager"
                , BigDecimal.TEN
                , LocalDate.now()
                , null);

        Employee first = new Employee(
                "first"
                , "FIRST"
                , BigDecimal.TEN
                , LocalDate.now()
                , manager);

        this.employeeService.save(first);

        manager = this.employeeService.findOneById(first.getManager().getId()).get();

        Employee second = new Employee(
                "second"
                , "SECOND"
                , BigDecimal.TEN
                , LocalDate.now()
                , manager);


        this.employeeService.save(second);
    }
}
