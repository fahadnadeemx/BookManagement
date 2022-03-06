package com.book.bookmanagementt.repository;
import com.book.bookmanagementt.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.book.bookmanagementt.service.BookService;

import java.util.List;
import java.util.Optional;

public interface Bookrepository extends JpaRepository<Book, Integer> {
}
//    BookService bookService;
//
//    private static final String TEMPORARY_IMPLEMENTATION =
//            "Temporary implementation";
//    public List<Book> findAll() {
//        throw new UnsupportedOperationException(TEMPORARY_IMPLEMENTATION);
//    }
//    public Optional<Book> findById(int id) {
//        throw new UnsupportedOperationException(TEMPORARY_IMPLEMENTATION);
//    }
//    public Book save(Book book) {
//        throw new UnsupportedOperationException(TEMPORARY_IMPLEMENTATION);
//    }
//    public boolean Deletebookbyid(Book book) {
//        throw new UnsupportedOperationException(TEMPORARY_IMPLEMENTATION);
//    }
//}

