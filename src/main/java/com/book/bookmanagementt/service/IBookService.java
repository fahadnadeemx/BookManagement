package com.book.bookmanagementt.service;

import com.book.bookmanagementt.entity.Book;
import java.util.List;

public interface IBookService {

    List<Book> loadAllBooks();

    Book loadBookById(int id);

    Book saveBook(Book book);

    Book updateBook(int id, Book book);

    void deleteBook(int id);
}



