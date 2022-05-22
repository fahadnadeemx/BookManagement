package com.book.bookmanagementt.service;

import com.book.bookmanagementt.model.BookDto;

import java.util.List;
import java.util.Optional;

public interface IBookService {

    List<BookDto> loadAllBooks();

    Optional<BookDto> loadBookById(int id);

    BookDto saveBook(BookDto book);

    BookDto updateBook(int id, BookDto book);

    void deleteBook(int id);
}



