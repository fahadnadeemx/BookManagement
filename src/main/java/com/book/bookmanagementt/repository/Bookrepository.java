package com.book.bookmanagementt.repository;
import com.book.bookmanagementt.entity.Book;
import org.springframework.stereotype.Repository;
import com.book.bookmanagementt.service.BookService;

import java.util.List;
import java.util.Optional;

@Repository
public class Bookrepository {
    BookService bookService;

    private static final String TEMPORARY_IMPLEMENTATION =
            "Temporary implementation";
    public List<Book> findAll() {
        throw new UnsupportedOperationException(TEMPORARY_IMPLEMENTATION);
    }
    public Optional<Book> findById(long id) {
        throw new UnsupportedOperationException(TEMPORARY_IMPLEMENTATION);
    }



}
