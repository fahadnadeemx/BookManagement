//package com.book.bookmanagementt.exceptions;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
//import java.util.Objects;
//
//@ResponseStatus(HttpStatus.BAD_REQUEST)
//public class BookExceptions extends RuntimeException {
//
//    public BookExceptions(String message) {
//        if (message.isEmpty()) {
//            throw new BookExceptions("Book Name :" + message + " Book Name is empty");
//        }
//        if (Objects.isNull(message)) {
//            throw new BookExceptions("Book Name :" + message + " Book Name is null");
//        }
//    }
//}
