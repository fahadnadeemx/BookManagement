package com.book.bookmanagementt.service;

import com.book.bookmanagementt.entity.Book;
import com.book.bookmanagementt.exceptions.BookExceptions;
import com.book.bookmanagementt.repository.Bookrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements  IBookService {

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
    public Book loadBookById(int id) {

        return bookrepository.findById(id).get();
    }

    @Override
    public Book saveBook(Book book) {
        try {
            return bookrepository.save(book);
        } catch (BookExceptions exception) {
            throw new BookExceptions(exception.getMessage());
        }

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