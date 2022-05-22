package com.book.bookmanagementt.controller;


import com.book.bookmanagementt.BookmanagementtApplication;
import com.book.bookmanagementt.entity.Book;
import com.book.bookmanagementt.entity.Category;
import com.book.bookmanagementt.model.BookDto;
import com.book.bookmanagementt.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.doNothing;
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
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringJUnit4ClassRunner.class)
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
        Category category = new Category(1, "Entertainment");

        List<BookDto> bookList = new ArrayList<>();
        bookList.add(new BookDto(1, "first", "first", 10, category));
        bookList.add(new BookDto(2, "second", "first", 20, category));
        bookList.add(new BookDto(3, "third", "first", 30, category));


        Mockito.when(bookService.loadAllBooks()).thenReturn(bookList);
        String url = "/books/allbooks";
        MvcResult mvcResult = mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();

        String actualJsonResponse = mvcResult.getResponse().getContentAsString();
        System.out.println(actualJsonResponse);

    }

    @Test
    public void testFindBookbyId() throws Exception {

        Category category = new Category(1, "Entertainment");

        BookDto bookDto = new BookDto(1, "first", "first", 10, category);

        Mockito.when(bookService.loadBookById(bookDto.getId())).thenReturn(Optional.of(bookDto));
        String url = "/books/find/1";
        MvcResult mvcResult = mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();

        String actualJsonResponse = mvcResult.getResponse().getContentAsString();
        System.out.println(actualJsonResponse);

    }

    @Test
    public void testCreateBook() throws Exception {

        Category category = new Category(1, "Entertainment");
        BookDto newBook = new BookDto(1, "first", "first", 10, category);
        Book savedBook = new Book(1, "first", "first", 10, category);

        Mockito.when(bookService.saveBook(newBook)).thenReturn(newBook);
        String url = "/books/save";

        mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(this.objectMapper.writeValueAsString(newBook)));
        Mockito.verify(bookService, Mockito.times(0)).saveBook(newBook);
    }

    @Test
    public void testUpdateBook() throws Exception {

        Category category = new Category(1, "Entertainment");
        BookDto newBook = new BookDto(1, "first", "first", 10, category);
        BookDto savedBook = new BookDto(1, "second", "second", 20, category);

        Mockito.when(bookService.updateBook(newBook.getId(), newBook)).thenReturn(savedBook);
        String url = "/books/update/" + savedBook.getId();
        mockMvc.perform(put(url)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(newBook)));
        Mockito.verify(bookService, Mockito.times(0)).saveBook(newBook);
    }

    @Test
    public void testBookNameMustNotBeBlank() throws Exception {
        bookService = Mockito.mock(BookService.class);
        Category category = new Category(1, "Entertainment");
        BookDto book = new BookDto(1, "", "Fahad", 1, category);
        Mockito.when(bookService.saveBook(book)).thenReturn(book);
        String url = "/books/save";
        mockMvc.perform(put(url)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(book)));

    }

    @Test
    public void testAuthorNameMustNotBeBlank() throws Exception {
        bookService = Mockito.mock(BookService.class);
        Category category = new Category(1, "Entertainment");
        BookDto book = new BookDto(1, "First", "", 1, category);
        Mockito.when(bookService.saveBook(book)).thenReturn(book);
        String url = "/books/save";

        mockMvc.perform(put(url)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(book)));

    }

    @Test
    public void testCategoryNameMustNotBeNull() throws Exception {
        bookService = Mockito.mock(BookService.class);
        Category category = new Category(1, "");
        BookDto book = new BookDto(1, "First", "Fahad", 1, category);
        Mockito.when(bookService.saveBook(book)).thenReturn(book);
        String url = "/books/save";

        mockMvc.perform(put(url)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(book)));

    }

    @Test
    public void testDeleteBookbyId() throws Exception {

        Category category = new Category(1, "Entertainment");

        BookDto bookDto = new BookDto(1, "first", "first", 10, category);

        doNothing().when(bookService).deleteBook(bookDto.getId());
        String url = "/books/delete/1";
        MvcResult mvcResult = mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();

        String actualJsonResponse = mvcResult.getResponse().getContentAsString();
        System.out.println(actualJsonResponse);

    }
}
