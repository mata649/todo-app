package com.mata649.todoapp.errors;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mata649.todoapp.errors.exceptions.ObjectNotFoundException;
import com.mata649.todoapp.errors.exceptions.UsernameAlreadyExistsException;


@ControllerAdvice
public class RestErrorHandler extends ResponseEntityExceptionHandler {
  Logger logger = LoggerFactory.getLogger(RestErrorHandler.class);

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<ErrorDTO> handleInternal(final RuntimeException ex) {
    logger.error(ex.getMessage());
    return ResponseEntity
        .status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(ErrorDTO.create("system error"));
  }

  @ExceptionHandler(ObjectNotFoundException.class)
  public ResponseEntity<ErrorDTO> handleNotFound(final ObjectNotFoundException e) {
    return new ResponseEntity<>(ErrorDTO.create(e.getMessage()), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(UsernameAlreadyExistsException.class)
  public ResponseEntity<ErrorDTO> handleUsernameAlreadyExists(final UsernameAlreadyExistsException e) {
    return new ResponseEntity<>(ErrorDTO.create(e.getMessage()), HttpStatus.CONFLICT);
  }

  @ExceptionHandler(BadCredentialsException.class)
  public ResponseEntity<ErrorDTO> handleBadCredentials(final BadCredentialsException e) {
    return new ResponseEntity<ErrorDTO>(ErrorDTO.create(e.getMessage()), HttpStatus.ACCEPTED);
  }

  @Override
  public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
      HttpStatus status, WebRequest request) {
    List<String> errors = ex.getBindingResult()
        .getFieldErrors()
        .stream()
        .map(x -> x.getDefaultMessage())
        .collect(Collectors.toList());
    Map<String, Object> body = new LinkedHashMap<>();

    body.put("errors", errors);
    return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);

  }
}