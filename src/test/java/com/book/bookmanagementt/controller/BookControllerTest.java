package com.book.bookmanagementt.controller;

//
//import com.book.bookmanagementt.entity.Book;
//import com.book.bookmanagementt.entity.Category;
//import com.book.bookmanagementt.repository.Bookrepository;
//import com.book.bookmanagementt.service.BookService;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static org.hamcrest.core.Is.is;
//import static org.junit.Assert.assertThat;
//import static org.mockito.Mockito.when;
//import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
//
///**
// * Invoke the Controller methods via HTTP.
// * Do not invoke the tourRatingService methods, use Mock instead
// * Created by Mary Ellen Bowman.
// *
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = RANDOM_PORT)
//public class BookControllerTest {
//    private static final String RATINGS_URL = "/books";
//
//    //These Tour and rating id's do not already exist in the db
//    private static final int BOOK_ID = 999;
//    private static final String BOOK_NAME = "First Book";
//    private static final String AUTHOR = "First Author";
//    private static final int PRICE = 3000;
//    private static final String CATEGORY = "Marvel";
//
//    @MockBean
//    private BookService bookService;
//
//    @Mock
//    private Book book;
//
//    @Mock
//    private Category category;
//
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//
//
//    @Before
//    public void setupReturnValuesOfMockMethods() {
//        when(bookService.loadAllBooks()).thenReturn((List<Book>) book);
//        when(book.getId()).thenReturn(BOOK_ID);
//        when(book.getBookname()).thenReturn(BOOK_NAME);
//        when(book.getAuthor()).thenReturn(AUTHOR);
//        when(book.getPrice()).thenReturn(PRICE);
//        when(category.getName()).thenReturn(CATEGORY);
//    }
//
//
//    /**
//     * HTTP GET /ratings
//     */
//    @Test
//    public void getRatings() {
//        when(bookService.loadAllBooks()).thenReturn(Arrays.asList(book));
//
//        ResponseEntity<List<Book>> response = restTemplate.exchange(RATINGS_URL, HttpMethod.GET, null,
//                new ParameterizedTypeReference<List<Book>>() {
//                });
//
//        assertThat(response.getStatusCode(), is(HttpStatus.OK));
//        assertThat(response.getBody().size(), is(3));
//    }
//}
//    /**
//     *  HTTP GET /ratings/{id}
//     */
////    @Test
////    public void getOne()  {
////
////        when(tourRatingServiceMock.lookupRatingById(RATING_ID)).thenReturn(Optional.of(tourRatingMock));
////
////        ResponseEntity<RatingDto> response =
////                restTemplate.getForEntity(RATINGS_URL + "/" + RATING_ID, RatingDto.class);
////
////        assertThat(response.getStatusCode(), is(HttpStatus.OK));
////        assertThat(response.getBody().getCustomerId(), is(CUSTOMER_ID));
////        assertThat(response.getBody().getComment(), is(COMMENT));
////        assertThat(response.getBody().getScore(), is(SCORE));
////    }
////}
//


import com.book.bookmanagementt.BookmanagementtApplication;
import com.book.bookmanagementt.entity.Book;
import com.book.bookmanagementt.service.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@WebMvcTest(BookController.class)
@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
//@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookmanagementtApplication.class)
public class BookControllerTest {
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    @Test
    public void testListofBooks() throws Exception {
//        bookService=Mockito.mock(BookService.class);
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(1, "first", "first", 10));
        bookList.add(new Book(2, "second", "first", 20));
        bookList.add(new Book(3, "third", "first", 30));
        Mockito.when(bookService.loadAllBooks()).thenReturn(bookList);
        String url = "/books";
        MvcResult mvcResult = mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();

        String actualJsonResponse = mvcResult.getResponse().getContentAsString();
        System.out.println(actualJsonResponse);

    }

    @Test
    public void testCreateBook() throws Exception {
//        bookService=Mockito.mock(BookService.class);

        Book newBook = new Book(1, "first", "first", 10);
        Book savedBook = new Book(1, "first", "first", 10);

        Mockito.when(bookService.saveBook(newBook)).thenReturn(savedBook);
        String url = "/books/save";
        mockMvc.perform(post(url).contentType("application/json")
                        .param("id", String.valueOf(newBook.getId()))
                        .param("price", String.valueOf(newBook.getPrice()))
                        .param("bookname", newBook.getBookname())
                        .param("author", newBook.getAuthor())).
                andExpect(status().isOk());
        Mockito.verify(bookService, Mockito.times(0)).saveBook(newBook);
    }

    @Test
    public void testUpdateBook() throws Exception {
//        bookService=Mockito.mock(BookService.class);

        Book newBook = new Book(1, "first", "first", 10);
        Book savedBook = new Book(1, "second", "second", 20);

        Mockito.when(bookService.updateBook(newBook.getId(), newBook)).thenReturn(savedBook);
        String url = "/books/update/" + savedBook.getId();
        mockMvc.perform(put(url).contentType("application/json")
                        .param("id", String.valueOf(newBook.getId()))
                        .param("price", String.valueOf(newBook.getPrice()))
                        .param("bookname", newBook.getBookname())
                        .param("author", newBook.getAuthor())).
                andExpect(status().isOk());
        Mockito.verify(bookService, Mockito.times(0)).saveBook(newBook);
    }

    @Test
    public void testBookNameMustNotBeBlank() throws Exception {
        bookService = Mockito.mock(BookService.class);
        Book book = new Book(1, "", "Fahad", 1);
        Mockito.when(bookService.saveBook(book)).thenReturn(book);
        String url = "/books/save";
        mockMvc.perform(post(url).contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("bookname", "")
                        .param("author", book.getAuthor()))
                .andExpect(status().isBadRequest());

    }

    @Test
    public void testAuthorNameMustNotBeBlank() throws Exception {
        bookService = Mockito.mock(BookService.class);
        Book book = new Book(1, "First", "", 1);
        Mockito.when(bookService.saveBook(book)).thenReturn(book);
        String url = "/books/save";
        mockMvc.perform(post(url).contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("bookname", book.getBookname())
                        .param("author", ""))
                .andExpect(status().isBadRequest());

    }
}
