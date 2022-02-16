package com.book.bookmanagementt.service;

import com.book.bookmanagementt.entity.Book;
import com.book.bookmanagementt.repository.Bookrepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private Bookrepository bookrepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void test_getAllBooks() {
        //Arrange
        Book book1 = new Book(1, "first", "Fahad", 1000);
        Book book2 = new Book(2, "second", "Nadeem", 5000);
        Mockito.when(bookrepository.findAll()).thenReturn(Arrays.asList(book1, book2));
        //Act
        List<Book> bookList = bookService.loadAllBooks();
        //Assert
        Assert.assertEquals(2, bookList.size());
    }
    @Test
    public void test_getBooksById_found() {
        //Arrange
        Book book1 = new Book(1, "first", "Fahad", 1000);
        Mockito.when(bookrepository.findById(1)).thenReturn(Optional.of(book1));

        List<Book> bookList = Collections.singletonList(bookService.loadBookById(1));
        Assert.assertEquals(1, bookList.size());
//        assertThat(employeeService.getEmployeeById(1))
//                .isSameAs(employee);
    }

}
