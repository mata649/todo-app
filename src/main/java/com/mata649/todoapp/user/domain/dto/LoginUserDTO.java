package com.mata649.todoapp.user.domain.dto;

import com.mata649.todoapp.user.domain.User;

public class LoginUserDTO {
    private String username;
    private String password;

    public User toUser() {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return user;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
