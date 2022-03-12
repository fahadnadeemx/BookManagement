package com.book.bookmanagementt.controller;


import com.book.bookmanagementt.BookmanagementtApplication;
import com.book.bookmanagementt.entity.Book;
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
