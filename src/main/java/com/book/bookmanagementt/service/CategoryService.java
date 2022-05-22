package com.book.bookmanagementt.service;

import com.book.bookmanagementt.entity.Category;
import com.book.bookmanagementt.mapper.ICategoryMapper;
import com.book.bookmanagementt.model.CategoryDto;
import com.book.bookmanagementt.repository.Categoryrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    Categoryrepository categoryRepository;

    private static final ICategoryMapper categoryMapper = ICategoryMapper.INSTANCE;

    @Override
    public List<CategoryDto> loadAllCategory() {
        List<Category> categoryList = categoryRepository.findAll();
        return categoryMapper.mapList(categoryList);
    }

    @Override
    public CategoryDto loadCategoryById(int id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent())
            return categoryMapper.mapDto(category.get());
        return new CategoryDto();
    }

    @Override
    public CategoryDto saveCategory(CategoryDto category) {
        Category categorys = categoryRepository.save(categoryMapper.map(category));
        return categoryMapper.mapDto(categorys);
    }

    @Override
    public void deleteCategory(int id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto category) {
        Category categoryx = categoryRepository.save(categoryMapper.map(category));
        return categoryMapper.mapDto(categoryx);
    }

}
