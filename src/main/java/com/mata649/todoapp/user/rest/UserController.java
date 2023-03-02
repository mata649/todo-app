package com.mata649.todoapp.user.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mata649.todoapp.user.domain.UserUseCases;
import com.mata649.todoapp.user.domain.dto.CreateUserDTO;
import com.mata649.todoapp.user.domain.dto.ResponseUserDTO;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserUseCases userService;

    @Autowired
    public UserController(UserUseCases userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @ApiOperation(value = "Insert a new user in the database", response = ResponseUserDTO.class)
    public ResponseEntity<ResponseUserDTO> create(@Valid @RequestBody CreateUserDTO createUserDTO) {
        return new ResponseEntity<>(userService.create(createUserDTO), HttpStatus.CREATED);

    }


    @GetMapping
    public ResponseEntity<List<ResponseUserDTO>> findAll() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseUserDTO> findOne(@PathVariable Long id) throws NotFoundException {
        return new ResponseEntity<>(userService.findOne(id), HttpStatus.OK);
    }

}
