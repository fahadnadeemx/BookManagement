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
    @JoinColumn(name = "Cid", referencedColumnName = "id")
    private Category category;


}

