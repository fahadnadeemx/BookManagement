package com.book.bookmanagementt.exceptions;

public class CustomExceptions extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public CustomExceptions(String message) {
        super(message);
    }
}
