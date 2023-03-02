package com.mata649.todoapp.user.domain.dto;


import javax.validation.constraints.Size;

import com.mata649.todoapp.user.domain.User;

public class CreateUserDTO {

    @Size(min = 4, max = 16, message = "username must be between 4 and 16 characters")
    private String username;

    @Size(min = 4, max = 40, message = "name must be between 4 and 16 characters")
    private String name;
    @Size(min = 8, max = 64, message = "password must be between 8 and 64 characters")
    private String password;

    public User toUser() {
        User user = new User();
  
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
  
        return user;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
