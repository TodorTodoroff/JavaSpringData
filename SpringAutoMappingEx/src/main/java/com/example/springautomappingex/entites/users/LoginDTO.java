package com.example.springautomappingex.entites.users;

import com.example.springautomappingex.exceptions.ValidationException;

public class LoginDTO {
    private String email;
    private String password;


    public LoginDTO(String[] commandParts) {
        this.email = commandParts[1];
        this.password = commandParts[2];
        this.validate();
    }

    private void validate() {
        int indexOfAt = email.indexOf("@");
        int indexOfDot = email.indexOf(".");

        if (indexOfAt < 0 || indexOfDot < 0 || indexOfAt > indexOfDot) {
            throw new ValidationException("Email must contain @ and .");
        }
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
