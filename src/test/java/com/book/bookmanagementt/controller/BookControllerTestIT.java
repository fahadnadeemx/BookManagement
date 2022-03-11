package com.book.bookmanagementt.controller;

import com.book.bookmanagementt.entity.Book;
import com.book.bookmanagementt.repository.Bookrepository;
import com.book.bookmanagementt.service.BookService;
import static org.assertj.core.api.Assertions.*;
import static org.hamcrest.Matchers.equalTo;
import org.apache.catalina.connector.Response;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.web.server.*;
import org.springframework.http.*;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookControllerTestIT {

    @Autowired
    private Bookrepository bookrepository;

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setup() {
        // always start with an empty database
        bookrepository.deleteAll();
        bookrepository.flush();

    }


//
//    @Test
//    void test_createNewBook() throws Exception {
//        Book book = new Book();
//        book.setId(1);
//        book.setBookname("Marvels");
//        book.setAuthor("Fahad Nadeem");
//        book.setPrice(1000);
//
//
//            assertTrue(
//                    this.restTemplate
//                            .getForObject("http://localhost:" + port + "/books", Book.class)
//                            ..size() == 3);
//
////        Response response = given().contentType(MediaType.APPLICATION_JSON_VALUE).body(book).when()
////                .post("/books/save");
//////
////        Book saved = response.getResponse().as(Book.class);
////
////        // read it back from the repository
////        assertThat(bookrepository.findById(saved.getId())).contains(saved);
//
//    @Sql({"schema.sql", "recipedb.sql"})
//    @Test
//    public void testAddEmployee() {
//
////        Response response = given().
////                contentType(MediaType.APPLICATION_JSON_VALUE).
////                body(new Book(1, "A book","Fahad", 1000)).
//
////                Book book = new Book();
////        book.setId(1);
////        book.setBookname("Marvels");
////        book.setAuthor("Fahad Nadeem");
////        book.setPrice(1000);
////
////        ResponseEntity<String> responseEntity = this.bookrepository
////                .postForEntity("http://localhost:" + port + "/save", book, String.class);
////        assertEquals(201, responseEntity.getStatusCodeValue());
////    }
//
//    }
}
