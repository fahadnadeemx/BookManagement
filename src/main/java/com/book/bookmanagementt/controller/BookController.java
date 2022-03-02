package com.book.bookmanagementt.controller;

import com.book.bookmanagementt.entity.Book;
import com.book.bookmanagementt.entity.Category;
import com.book.bookmanagementt.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Validated
@RequestMapping("/books")
public class BookController {


    /* Injecting services of books in the controller */
    @Autowired
    BookService bookService;

    /* Injecting services of category in the controller */
//    @Autowired
//    CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET)
    private String getAllBooks(Model model) {
        List<Book> list = bookService.loadAllBooks();
        model.addAttribute("allBooks", list);
        return "books";
    }

    /* Redirect to new book page along with categories list
     * books/new => redirect to a new page
     */
    @RequestMapping("/new")
    public String showNewBookPage(Model model, @ModelAttribute("category") Category category) {
        Book book = new Book();
        model.addAttribute("book", book);
        List<Category> list =new ArrayList<>();// categoryService.loadAllCategory();
        model.addAttribute("allCategory", list);
        return "add-book";
    }

    /*
     * Save entity model with its foreign reference
     * Entity i.e, Book and reference i.e, category
     * books/new => to create a new model object
     */
    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public String saveNewBook(@ModelAttribute("book") Book book) {
        bookService.saveBook(book);
        return "redirect:/books";
    }


    /*
     * Redirect to edit book page along with categories list
     * books/edit/{id} => redirect to a edit book page with selected id
     */
    @GetMapping("/edit/{id}")
    private String editBook(@PathVariable("id") int id, Model model) {
        Book book = bookService.loadBookById(id);
        model.addAttribute("book", book);
//        List<Category> list = categoryService.loadAllCategory();
//        model.addAttribute("allCategory", list);
        return "edit-book";
    }



    /*
     * Update entity model with its foreign reference
     * Entity i.e, Book and reference i.e, category
     * books/update/{id} => to update existing model object
     */
    @RequestMapping(path = "/update/{id}", method = RequestMethod.POST)
    private String updateBook(@PathVariable("id") int id, @ModelAttribute Book book) {
        bookService.updateBook( id,book);
        return "redirect:/books";
    }



    /*
     * Delete entity model with its foreign reference
     * Entity i.e, Book and reference i.e, category
     * books/delete/{id} => to delete an existing model object
     */
    @GetMapping("/delete/{id}")
    private String deleteBook(@PathVariable("id") int id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }


}