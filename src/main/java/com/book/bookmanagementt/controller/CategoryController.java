package com.book.bookmanagementt.controller;


import com.book.bookmanagementt.model.CategoryDto;
import com.book.bookmanagementt.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping()
    public ResponseEntity<List<CategoryDto>> getAllCategory() {
        List<CategoryDto> list = categoryService.loadAllCategory();
        return ResponseEntity.ok(list);
    }

    @PostMapping(path = "/save")
    public ResponseEntity<CategoryDto> saveNewCategory(@RequestBody CategoryDto category) {
        CategoryDto categoryx;

        categoryx = categoryService.saveCategory(category);

        return ResponseEntity.ok(categoryx);
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<CategoryDto> find(@PathVariable("id") int id) {
        CategoryDto category = categoryService.loadCategoryById(id);
        return ResponseEntity.ok(category);

    }

    @PostMapping(path = "/update/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable("id") int id, @RequestBody CategoryDto category) {
        CategoryDto categoryx;

        categoryx = categoryService.updateCategory(category);

        return ResponseEntity.ok(categoryx);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteCategory(@PathVariable("id") int id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok(Boolean.TRUE);
    }
}
