package com.example.day1.users;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserControllerAdvice {

    @ExceptionHandler(DuplicateFirstnameException.class)
    public ResponseEntity<MyError> gotException(DuplicateFirstnameException e) {
        MyError error = new MyError();
        error.setCode("24000");
        error.setDescription("Firstname duplicated");
        return new ResponseEntity<>(error, HttpStatus.valueOf(400));
    }
}
