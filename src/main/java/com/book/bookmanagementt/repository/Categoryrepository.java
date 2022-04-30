package com.book.bookmanagementt.repository;

import com.book.bookmanagementt.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Categoryrepository extends JpaRepository<Category, Integer> {
}
