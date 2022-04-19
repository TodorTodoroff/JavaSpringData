package com.example.springautomappingobjects.demo;

import com.example.springautomappingobjects.demo.dto.ManagerDto;
import com.example.springautomappingobjects.demo.entities.Address;
import com.example.springautomappingobjects.demo.entities.Employee;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MapperMain {
    public static void main(String[] args) {
        ModelMapper mapper = new ModelMapper();

        Address address = new Address("boris str", 3, "Sofia", "Bulgaria");

        Employee employee = new Employee("Pesho", "Todorov"
                , BigDecimal.valueOf(4300.00), LocalDate.now(), address, false);

        Employee manager = new Employee("Ivan", "Ivanov"
                , BigDecimal.valueOf(4800.00), LocalDate.now(), address, true);

        Employee employee2 = new Employee("Jimmeh", "Parkov"
                , BigDecimal.valueOf(7800.00), LocalDate.now(), address, false);

        manager.addEmployee(employee);
        manager.addEmployee(employee2);

        ManagerDto dto = mapper.map(manager, ManagerDto.class);

        System.out.println(dto);

    }
}
