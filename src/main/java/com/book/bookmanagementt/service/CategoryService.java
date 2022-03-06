package com.book.bookmanagementt.service;

import com.book.bookmanagementt.entity.Book;
import com.book.bookmanagementt.entity.Category;
import com.book.bookmanagementt.repository.Categoryrepository;

import java.util.List;

public class CategoryService {

    Categoryrepository categoryRepository;

    public List<Category> loadAllCategory(){

        return (List<Category>) categoryRepository.findAll();
    }

    public Category loadCategoryById(int id) {

        return categoryRepository.findById(id).get();
    }

    public Category saveCategory(Category category) {

        return categoryRepository.save(category);
    }

    public void deleteCategory(int id) {

        categoryRepository.deleteById(id);
    }

    public Category updateCategory(Category category) {

        return categoryRepository.save(category);
    }

}
