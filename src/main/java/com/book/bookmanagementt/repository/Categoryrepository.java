package com.book.bookmanagementt.repository;

import com.book.bookmanagementt.entity.Book;
import com.book.bookmanagementt.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface Categoryrepository extends JpaRepository<Category, Integer> {
}
//public class Categoryrepository {
//    private static final String TEMPORARY_IMPLEMENTATION =
//            "Temporary implementation";
//
//    public List<Category> findAll() {
//
//        throw new UnsupportedOperationException(TEMPORARY_IMPLEMENTATION);
//    }
//    public Optional<Category> findById(int id) {
//
//        throw new UnsupportedOperationException(TEMPORARY_IMPLEMENTATION);
//    }
//    public Category save(Category category) {
//        throw new UnsupportedOperationException(TEMPORARY_IMPLEMENTATION);
//    }
//    public Category deleteById(int id) {
//        throw new UnsupportedOperationException(TEMPORARY_IMPLEMENTATION);
//    }
//}
