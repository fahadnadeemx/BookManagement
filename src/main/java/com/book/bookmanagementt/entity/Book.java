package com.book.bookmanagementt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String bookname;

    private String author;
    private int price;

    @ManyToOne
    @JoinColumn(name="Cid", referencedColumnName = "id")
    private Category category;


//    public void validate(Book book) {
//        if (book.getBookname().isEmpty()) {
//            throw new IllegalArgumentException("Book Name is Empty :" + book.getBookname() + " Book Name is empty");
//        } else if (Objects.isNull(book.getBookname())) {
//            throw new IllegalArgumentException("Book Name is Null :" + book.getBookname() + " Book Name is null");
//        } else if (book.getAuthor().isEmpty()) {
//            throw new IllegalArgumentException("Author is Empty :" + book.getAuthor() + " Author Name is empty");
//        } else if (Objects.isNull(book.getAuthor())) {
//            throw new IllegalArgumentException("Author is Null :" + book.getAuthor() + " Author is null");
//        }
//        else if (Objects.isNull(book.getCategory())) {
//            throw new IllegalArgumentException("Category  is Null:" + book.getCategory() + " Category is null");
//        }
//    }
}

