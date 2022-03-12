package com.book.bookmanagementt.controller;

import com.book.bookmanagementt.entity.Book;
import com.book.bookmanagementt.repository.Bookrepository;

import static org.assertj.core.api.Assertions.*;
import static io.restassured.RestAssured.*;

import com.book.bookmanagementt.service.BookService;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.http.*;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import io.restassured.response.*;

import java.net.URI;
import java.util.*;

import static io.restassured.RestAssured.*;
import static org.assertj.core.api.Assertions.*;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.web.server.*;
import org.springframework.http.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;
import org.springframework.test.util.ReflectionTestUtils;

import javax.inject.Inject;


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
        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }


    @Test
    public void test_createNewBook() throws Exception {
        Book book = new Book();
        book.setId(1);
        book.setBookname("Marvels");
        book.setAuthor("Fahad Nadeem");
        book.setPrice(1000);
// create an employee with POST

//        Response response = given()
//                .contentType(MediaType.APPLICATION_JSON_VALUE)
////                .param("id", String.valueOf(book.getId()))
////                .param("price", String.valueOf(book.getPrice()))
////                .param("bookname", book.getBookname())
////                .param("author", book.getAuthor())
//                .body(book) .when().
//                post("/books/save");

        String url = "/books/save";
//        mockMvc.perform(post(url).contentType(MediaType.APPLICATION_FORM_URLENCODED)
//                        .param("id", String.valueOf(book.getId()))
//                        .param("price", String.valueOf(book.getPrice()))
//                        .param("bookname", book.getBookname())
//                        .param("author", book.getAuthor())).
//                andExpect(status().isOk());

//        mockMvc.perform(post(url)
//                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                .content(TestUtil.convertObjectToJsonBytes(mailServer))).
//                andExpect(status().isOk());


        final String baseUrl = "http://localhost:8080/books/save";
        URI uri = new URI(baseUrl);

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");

        HttpEntity<Book> request = new HttpEntity<>(book, headers);

        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);

        //Verify request succeed
//        Assert.assertEquals(201, result.getStatusCodeValue());

//        String saved = response.getBody().as(String.class);
// read it back from the repository

        Optional<Book> ex = bookrepository.findById(book.getId());

        assertEquals(book.getBookname(), ex.get().getBookname());

    }
//    @Test
//    public void testUpdateEmployee() throws Exception {
//// create an employee with the repository
//        Book saved = bookrepository
//                .save(new Book(1, "original name","fahad", 1000));
//// modify it with PUT
//        given().
//                contentType(MediaType.APPLICATION_JSON_VALUE).
//                body(new Book(1, "modified name","fahad nadeem", 100)).
//                when().
//                put("/books/update/" + saved.getId()).
//                then().
//                statusCode(200).
//                body(
//// in the JSON response the id is an integer
//                        "id", equalTo(saved.getId().intValue()),
//                        "name", equalTo("modified name"),
//                        "price", equalTo(100)
//                );
//    }

}
