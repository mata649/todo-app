package com.mata649.todoapp.errors;

public class ErrorDTO {
    private String message;

    public static ErrorDTO create(String message) {
        ErrorDTO errorDTO = new ErrorDTO(message);
        return errorDTO;
                
    }

    public ErrorDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    

}
