package com.book.bookmanagementt.repository;

import com.book.bookmanagementt.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Bookrepository extends JpaRepository<Book, Integer> {
}


