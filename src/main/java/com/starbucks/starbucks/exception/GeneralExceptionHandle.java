package com.starbucks.starbucks.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralExceptionHandle {
    @ExceptionHandler(EdevletException.class)
    public ResponseEntity<String> handle(EdevletException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);     }
    @ExceptionHandler(UserException.class)
    public ResponseEntity<String> handle(UserException userException){
    return new ResponseEntity<>(userException.getMessage(), HttpStatus.BAD_REQUEST);     }  }
