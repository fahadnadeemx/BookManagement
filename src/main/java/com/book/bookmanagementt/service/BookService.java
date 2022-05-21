package com.book.bookmanagementt.service;

import com.book.bookmanagementt.entity.Book;
import com.book.bookmanagementt.exceptions.CustomExceptions;
import com.book.bookmanagementt.repository.Bookrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookService implements IBookService {

    @Autowired
    public Bookrepository bookrepository;

    public BookService(Bookrepository bookrepository) {
        this.bookrepository = bookrepository;
    }

    @Override
    public List<Book> loadAllBooks() {

        return bookrepository.findAll();
    }

    @Override
    public Optional<Book> loadBookById(int id) {
        return bookrepository.findById(id);
    }

    @Override
    public Book saveBook(Book book) {
//        if (book.getBookname().isEmpty() || Objects.isNull(book.getBookname()))
//            Throw new CustomExceptions("Please write book name!");
//        else if (book.getAuthor().isEmpty() || Objects.isNull(book.getAuthor()))
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        else
            return bookrepository.save(book);
    }

    @Override
    public Book updateBook(int id, Book book) {
        book.setId(id);
        return bookrepository.save(book);
    }

    @Override
    public void deleteBook(int id) {
        bookrepository.deleteById(id);
    }
}