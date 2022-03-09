package com.book.bookmanagementt.controller;

import com.book.bookmanagementt.entity.Category;
import com.book.bookmanagementt.service.ICategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    ICategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET)
    private String getAllCategory(Model model) {
        List<Category> list = categoryService.loadAllCategory();
        model.addAttribute("allCategory", list);
//        return "categories";
        return "categories";
    }
    @RequestMapping("/new")
    public String showNewCategoryPage(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "add-category";
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public ResponseEntity<String>  saveNewCategory(@ModelAttribute("category") Category category) {

        if (category.getName().isEmpty() || Objects.isNull(category.getName()))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        else
             categoryService.saveCategory(category);

        return ResponseEntity.ok("redirect:/index");
    }


    @GetMapping("/edit/{id}")
    private String editCategory(@PathVariable("id") int id, Model model) {
        Category category = categoryService.loadCategoryById(id);
        model.addAttribute("category", category);
        return "edit-category";
    }
    @RequestMapping(path = "/update/{id}", method = RequestMethod.POST)
    private String updateCategory(@PathVariable("id") int id, @ModelAttribute Category category) {
        category.setId(id);
        categoryService.updateCategory(category);
        return "redirect:/categories";
    }
    @GetMapping("/delete/{id}")
    private String deleteCategory(@PathVariable("id") int id) {
        categoryService.deleteCategory(id);
        return "redirect:/categories";
    }
}
