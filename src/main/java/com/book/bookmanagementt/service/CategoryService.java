package com.book.bookmanagementt.service;

import com.book.bookmanagementt.entity.Category;
import com.book.bookmanagementt.repository.Categoryrepository;

import java.util.List;

public class CategoryService implements ICategoryService{

    Categoryrepository categoryRepository;

    @Override
    public List<Category> loadAllCategory(){
        return categoryRepository.findAll();
    }

    @Override
    public Category loadCategoryById(int id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(int id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }

}
