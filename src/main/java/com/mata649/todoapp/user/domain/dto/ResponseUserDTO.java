package com.mata649.todoapp.user.domain.dto;

import com.mata649.todoapp.user.domain.User;

public class ResponseUserDTO {
    private Long id;
    private String username;
    private String name;

    public static ResponseUserDTO fromUser(User user) {
        ResponseUserDTO responseUserDTO = new ResponseUserDTO();
        responseUserDTO.setId(user.getId());
        responseUserDTO.setUsername(user.getUsername());
        responseUserDTO.setName(user.getName());
        return responseUserDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

}
