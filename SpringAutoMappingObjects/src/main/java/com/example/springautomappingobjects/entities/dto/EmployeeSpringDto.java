package com.example.springautomappingobjects.entities.dto;

import java.math.BigDecimal;

public class EmployeeSpringDto {
    private String firstName;
    private  String lastName;
    private BigDecimal salary;
    private String managerLastName;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public void setManagerLastName(String managerLastName) {
        this.managerLastName = managerLastName;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f - Manager:  %s "
        ,this.firstName, this.lastName , this.salary
                        , this.managerLastName == null ? "[no manager]" : this.managerLastName);
    }
}
