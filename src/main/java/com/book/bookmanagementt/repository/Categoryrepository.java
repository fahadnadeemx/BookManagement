package com.book.bookmanagementt.repository;

import com.book.bookmanagementt.entity.Book;
import com.book.bookmanagementt.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface Categoryrepository extends JpaRepository<Category, Integer> {
}
