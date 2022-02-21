package com.book.bookmanagementt.controller;

import com.book.bookmanagementt.entity.Book;
import com.book.bookmanagementt.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
public class BookControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private BookService bookService;

    @Test
    public void testListofBooks() throws Exception{
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(1,"first", "first",10));
        bookList.add(new Book(2,"second", "first",20));
        bookList.add(new Book(3,"third", "first",30));
        Mockito.when(bookService.loadAllBooks()).thenReturn(bookList);
        String url = "/books";
//        mockMvc.perform().andExpect(status().isOk());
    }
}
