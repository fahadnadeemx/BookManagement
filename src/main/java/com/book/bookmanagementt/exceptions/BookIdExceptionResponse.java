package com.book.bookmanagementt.exceptions;

public class BookIdExceptionResponse {

    private final String bookId;

    public BookIdExceptionResponse(String bookId) {
        this.bookId = bookId;
    }

    public String getBookId() {
        return bookId;

    }
}
