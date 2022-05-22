package com.book.bookmanagementt.service;

import com.book.bookmanagementt.BookmanagementtApplication;
import com.book.bookmanagementt.entity.Book;
import com.book.bookmanagementt.entity.Category;
import com.book.bookmanagementt.model.BookDto;
import com.book.bookmanagementt.repository.Bookrepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BookmanagementtApplication.class)
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
        List<Book> list = new ArrayList<Book>();
        Category category = new Category(1, "Entertainment");
        Book book1 = new Book(1, "first", "Fahad", 1000, category);
        Book book2 = new Book(2, "second", "Nadeem", 5000, category);
        list.add(book1);
        list.add(book2);
        when(bookrepository.findAll()).thenReturn(list);

        List<BookDto> bookList = bookService.loadAllBooks();

        assertEquals(2, bookList.size());
    }

    @Test
    public void test_getBooksById_found() {
        //Arrange
        Category category = new Category(1, "Entertainment");
        Book book1 = new Book(1, "first", "Fahad", 1000, category);
        when(bookrepository.findById(1)).thenReturn(Optional.of(book1));

        Optional<BookDto> bookList = bookService.loadBookById(1);
        assertEquals(1, bookList.get().getId());

    }

    @Test
    public void SavedBook() {
        Category category = new Category(1, "Entertainment");
        BookDto book1 = new BookDto(1, "first", "Fahad", 1000, category);
        Book book = new Book(1, "first", "Fahad", 1000, category);

        when(bookrepository.save(book)).thenReturn(book);
        BookDto resultant = bookService.saveBook(book1);
        assertEquals(book1, resultant);
    }

    @Test
    public void test_updatebook() {
        Category category = new Category(1, "Entertainment");
        BookDto replacement = spy(new BookDto(-2, "first", "Fahad", 1000, category));
        BookDto replaced = new BookDto(2, "saved", "saved", 5000, category);
        Book bookReplacement = spy(new Book(-2, "first", "Fahad", 1000, category));
        when(bookrepository.save(bookReplacement)).thenReturn(bookReplacement);
        BookDto bookList = bookService.updateBook(replaced.getId(), replacement);
        assertEquals(replacement, bookList);
    }

    @Test
    public void test_deletebook() {
        Category category = new Category(1, "Entertainment");
        Book book = new Book(2, "saved", "saved", 5000, category);
        doNothing().when(bookrepository).deleteById(book.getId());
        bookService.deleteBook(book.getId());

    }
}
