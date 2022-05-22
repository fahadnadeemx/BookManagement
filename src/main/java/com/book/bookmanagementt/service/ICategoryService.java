package com.book.bookmanagementt.service;

import com.book.bookmanagementt.model.CategoryDto;

import java.util.List;

public interface ICategoryService {

    List<CategoryDto> loadAllCategory();

    CategoryDto loadCategoryById(int id);

    CategoryDto saveCategory(CategoryDto category);

    void deleteCategory(int id);

    CategoryDto updateCategory(CategoryDto category);

}
