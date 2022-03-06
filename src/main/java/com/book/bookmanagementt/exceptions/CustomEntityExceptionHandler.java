package com.book.bookmanagementt.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class CustomEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BookExceptions.class)
    protected final ResponseEntity<Object> handleDuplicateUserExp(BookExceptions exception){
        var response = new BookIdExceptionResponse(exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
