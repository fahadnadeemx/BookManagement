package com.book.bookmanagementt.service;

import com.book.bookmanagementt.entity.Category;

import java.util.List;

public interface ICategoryService {

     List<Category> loadAllCategory();

     Category loadCategoryById(int id) ;

     Category saveCategory(Category category);

     void deleteCategory(int id) ;

     Category updateCategory(Category category) ;

}
