package com.mata649.todoapp.errors.exceptions;

public class UsernameAlreadyExistsException extends RuntimeException{

    public UsernameAlreadyExistsException() {
        super("Username already exists");
    }
    
}
