package com.book.bookmanagementt.controller;

import com.book.bookmanagementt.model.BookDto;
import com.book.bookmanagementt.service.BookService;
import com.book.bookmanagementt.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    /* Injecting services of books in the controller */

    @Autowired
    private BookService bookService;

    @Autowired
    private IBookService iBookService;

    @Inject
    public BookController(BookService bookService, IBookService iBookService) {
        this.bookService = bookService;
        this.iBookService = iBookService;
    }

    /* Injecting services of category in the controller */

    @GetMapping("/allbooks")
    public List<BookDto> getAllBooks() {
        return bookService.loadAllBooks();
    }

    /*
     * Save entity model with its foreign reference
     * Entity i.e, Book and reference i.e, category
     * books/new => to create a new model object
     */

    @GetMapping("/find/{id}")
    public ResponseEntity<BookDto> loadbyId(@PathVariable("id") int id) {
        Optional<BookDto> book = bookService.loadBookById(id);
        if (book.isPresent()) {
            return ResponseEntity.ok(book.get());
        }
        return ResponseEntity.badRequest().body(new BookDto());
    }

    @PostMapping(path = "/save")
    public ResponseEntity<BookDto> saveNewBook(@RequestBody BookDto book) {
        BookDto response;
//        if (book.getBookname().isEmpty() || Objects.isNull(book.getBookname()))
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        else if (book.getAuthor().isEmpty() || Objects.isNull(book.getAuthor()))
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        else
            response = bookService.saveBook(book);
        return ResponseEntity.ok(response);
    }

    /*
     * Update entity model with its foreign reference
     * Entity i.e, Book and reference i.e, category
     * books/update/{id} => to update existing model object
     */
    @PostMapping(path = "/update/{id}")
    public ResponseEntity<BookDto> updateBook(@PathVariable("id") int id, @RequestBody BookDto book) {
        return ResponseEntity.ok(bookService.updateBook(id, book));
    }


    /*
     * Delete entity model with its foreign reference
     * Entity i.e, Book and reference i.e, category
     * books/delete/{id} => to delete an existing model object
     */
    @GetMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteBook(@PathVariable("id") int id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok(Boolean.TRUE);
    }


}