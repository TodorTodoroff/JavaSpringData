package com.example.springautomappingobjects.demo.dto;

import java.util.List;
import java.util.stream.Collectors;

public class ManagerDto {
    private String firstName;
    private String lastName;
    private List<EmployeeDto> subordinates;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSubordinates(List<EmployeeDto> subordinates) {
        this.subordinates = subordinates;
    }

    @Override
    public String toString() {
        String employeeFormat = this.subordinates
                .stream()
                .map(EmployeeDto::toString)
                .map(s -> "   - " + s)
                .collect(Collectors.joining(System.lineSeparator()));

        return String.format("%s %s | Employees: %d%n%s%n"
        ,this.firstName, this.lastName, this.subordinates.size()
        ,employeeFormat);
    }
}
