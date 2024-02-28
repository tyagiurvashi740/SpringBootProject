package com.example.springBootProject.controller;

import com.example.springBootProject.error.ErrorMessage;
import com.example.springBootProject.exception.PostNotFoundException;
import com.example.springBootProject.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseStatus
public class AllExceptionHandlers {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorMessage> exceptionHandler(UserNotFoundException exception){
    ErrorMessage message= new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
       return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);



    }
    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<ErrorMessage> exceptionHandler(PostNotFoundException exception){
        ErrorMessage message= new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);



    }

}
