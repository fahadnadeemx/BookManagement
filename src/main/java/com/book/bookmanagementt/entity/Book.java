package com.book.bookmanagementt.entity;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;


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
        private String bookname;
        private String author;
        private int price;

    }

