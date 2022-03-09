package com.book.bookmanagementt.repository;
import com.book.bookmanagementt.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.book.bookmanagementt.service.BookService;

import java.util.List;
import java.util.Optional;

public interface Bookrepository extends JpaRepository<Book, Integer> {
}


