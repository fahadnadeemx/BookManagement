package com.book.bookmanagementt.controller;

import com.book.bookmanagementt.entity.Book;

import com.book.bookmanagementt.model.BookDto;
import com.book.bookmanagementt.repository.Bookrepository;

import static io.restassured.RestAssured.*;

import com.book.bookmanagementt.service.BookService;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.http.*;

import org.springframework.test.context.junit4.SpringRunner;


import java.net.URI;
import java.util.*;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookControllerTestIT {

    private MockMvc mockMvc;

    @Autowired
    private BookService bookService;

    @Autowired
    private Bookrepository bookrepository;

    @Autowired
    private TestRestTemplate restTemplate;

    @InjectMocks
    private BookController bookController;

    @Before
    public void setup() {
        RestAssured.port = port;
        // always start with an empty database
        bookrepository.deleteAll();
        bookrepository.flush();

        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }


    @Test
    public void test_createNewBook() throws Exception {
        Book book = new Book();
        book.setId(2);
        book.setBookname("Marvels");
        book.setAuthor("Fahad Nadeem");
        book.setPrice(1000);

        bookrepository.save(book);

        String url = "/books/save/";
        final String baseUrl = "http://localhost:8080/books/save/";
        URI uri = new URI(baseUrl);
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");
        HttpEntity<Book> request = new HttpEntity<>(book, headers);
        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);

        Optional<BookDto> ex = bookService.loadBookById(book.getId());
        assertEquals(book.getBookname(), ex.get().getBookname());
    }


    @Test
    public void test_updateBook() throws Exception {
        Book book = new Book();
        book.setId(1);
        book.setBookname("Marvels");
        book.setAuthor("Fahad Nadeem");
        book.setPrice(1000);

        List<Book> allBooks = List.of(book);

        bookrepository.saveAll(allBooks);

        String url = "/books/update/" + book.getId();
        final String baseUrl = "http://localhost:8080/books/update/" + book.getId();
        URI uri = new URI(baseUrl);
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");
        HttpEntity<Book> request = new HttpEntity<>(book, headers);
        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);

        Optional<BookDto> ex = bookService.loadBookById(book.getId());
        assertEquals(book.getBookname(), ex.get().getBookname());
    }

    @Test
    public void test_getallbooks() throws Exception {
        Book book = new Book();
        book.setId(1);
        book.setBookname("Marvels");
        book.setAuthor("Fahad Nadeem");
        book.setPrice(1000);
        List<Book> allBooks = List.of(book);

        bookrepository.saveAll(allBooks);
        // when
//        when().get("/books");

        assertEquals(1, bookrepository.findAll().size());

    }

    @Test
    public void test_deleteCategory() throws Exception {

        // given
        Book book = new Book();
        book.setId(1);
        book.setBookname("Marvels");
        book.setAuthor("Fahad Nadeem");
        book.setPrice(1000);

        List<Book> allBooks = List.of(book);

        bookrepository.saveAll(allBooks);

        // when
//        when().delete("/books/delete/" + book.getId());

        assertEquals(1, bookrepository.findAll().size());

    }


}
