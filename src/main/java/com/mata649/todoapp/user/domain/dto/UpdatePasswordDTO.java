package com.mata649.todoapp.user.domain.dto;

import javax.validation.constraints.Size;

import com.mata649.todoapp.user.domain.User;

public class UpdatePasswordDTO {
    private Long id;
    @Size(min = 8, max = 64, message = "password must be between 8 and 64 characters")
    private String password;

    public User toUser() {
        User user = new User();
        user.setId(id);
        user.setPassword(password);
        return user;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
