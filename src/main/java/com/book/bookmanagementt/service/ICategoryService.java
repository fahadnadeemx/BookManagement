package com.book.bookmanagementt.service;

import com.book.bookmanagementt.entity.Category;
import com.book.bookmanagementt.model.CategoryDto;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {

     List<CategoryDto> loadAllCategory();

     CategoryDto loadCategoryById(int id) ;

     CategoryDto saveCategory(CategoryDto category);

     void deleteCategory(int id) ;

     CategoryDto updateCategory(CategoryDto category) ;

}
