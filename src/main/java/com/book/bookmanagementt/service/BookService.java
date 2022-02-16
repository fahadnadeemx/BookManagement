package com.book.bookmanagementt.service;

import com.book.bookmanagementt.entity.Book;
import com.book.bookmanagementt.repository.Bookrepository;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    public Bookrepository bookrepository;


    public BookService(Bookrepository bookrepository) {
        this.bookrepository = bookrepository;
    }

    public List<Book> loadAllBooks() {

        return bookrepository.findAll();
    }
    public Book loadBookById(int id) {

        return bookrepository.findById(id).get();
    }
}

