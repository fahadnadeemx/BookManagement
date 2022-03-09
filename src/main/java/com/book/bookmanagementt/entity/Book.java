package com.book.bookmanagementt.entity;

import com.book.bookmanagementt.service.BookService;
import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Objects;


@Entity
public class Book {

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Id
    private int id;

    public Book(int id, String bookname, String author, int price) {
        this.id = id;
        this.bookname = bookname;
        this.author = author;
        this.price = price;
    }

    @NotNull
//        @NotBlank(message = "Book Name is mandatory")
    private String bookname;

    @NotNull
    @NotBlank(message = "Author Name is mandatory")
    private String author;

    private int price;

    public void validate(Book book) {
        if (book.getBookname().isEmpty()) {
            throw new IllegalArgumentException("Book Name :" + book.getBookname() + " Book Name is empty");
        } else if (Objects.isNull(book.getBookname())) {
            throw new IllegalArgumentException("Book Name :" + book.getBookname() + " Book Name is null");
        } else if (book.getAuthor().isEmpty()) {
            throw new IllegalArgumentException("Author :" + book.getAuthor() + " Author Name is empty");
        } else if (Objects.isNull(book.getAuthor())) {
            throw new IllegalArgumentException("Author :" + book.getAuthor() + " Author is null");
        }
    }
}

