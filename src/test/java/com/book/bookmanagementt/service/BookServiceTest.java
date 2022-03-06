package com.book.bookmanagementt.service;

import com.book.bookmanagementt.BookmanagementtApplication;
import com.book.bookmanagementt.entity.Book;
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
        Book book1 = new Book(1, "first", "Fahad", 1000);
        Book book2 = new Book(2, "second", "Nadeem", 5000);
        list.add(book1);
        list.add(book2);
        when(bookrepository.findAll()).thenReturn(list);

        List<Book> bookList = bookService.loadAllBooks();

        assertEquals(2, bookList.size());
    }

    @Test
    public void test_getBooksById_found() {
        //Arrange
        Book book1 = new Book(1, "first", "Fahad", 1000);
        when(bookrepository.findById(1)).thenReturn(Optional.of(book1));

        List<Book> bookList = Collections.singletonList(bookService.loadBookById(1));
        assertEquals(1, bookList.size());
//        assertThat(employeeService.getEmployeeById(1))
//                .isSameAs(employee);
    }

    @Test
    public void SavedBook() {
//        Book saved = new Book(2, "second", "Nadeem", 5000);
//);
////        List<Book> bookList  = (List<Book>) bookService.saveBook(saved);
////        Assert.assertEquals(bookList).isSameAs(saved);
//
//        Book savedBook = bookrepository.save(saved);
//        Assert.assertEquals(1,savedBook.getId());
//        Assert.assertThat()
//                .isEqualTo(getBookname());

//        Book saved = new Book(2, "second", "Nadeem", 5000);
//        when(bookrepository.save(any(Book.class)))
//                .thenReturn(new Book());
////        bookService.saveBook(saved);
////        assertEquals(1, bookrepository.save(saved));
//        Book created = bookService.saveBook(saved);
//        Assert.assertThat().isSameAs(saved);
////        verify(bookrepository, times(1)).saveBook(saved);
//
//        Book createBookRequest = new Book();
//        createBookRequest.setId(1);
//        createBookRequest.setBookname("Harry Potter");
//        createBookRequest.setAuthor("Cartoon");
//        createBookRequest.setPrice(200);
//        when(bookrepository.save(any(Book.class))).thenReturn(new Book());
//        Book created = bookService.saveBook(createBookRequest);
//        Assert.assertThat(bookService.save(createBookRequest).equals(created);

        Book book1 = new Book(1, "first", "Fahad", 1000);
        when(bookrepository.save(book1)).thenReturn(book1);
        Book resultant = bookService.saveBook(book1);
        assertEquals(book1, resultant);
    }

    @Test
    public void test_updatebook() {
        Book replacement = spy(new Book(-2, "first", "Fahad", 1000));
        Book replaced = new Book(2, "saved", "saved", 5000);
        when(bookrepository.save(replacement))
                .thenReturn(replacement);
        Book bookList = bookService.updateBook(replaced.getId(), replacement);
        assertEquals(replacement, bookList);
//
//        InOrder inOrder = inOrder(replacement, bookrepository);
//        inOrder.verify(replacement).setId(2);
//        inOrder.verify(bookrepository).save(replacement);

    }

    @Test
    public void test_deletebook() {
        Book book = new Book(2, "saved", "saved", 5000);

     doNothing().when(bookrepository).deleteById(book.getId());

//        verify(bookService, atLeastOnce()).deleteBook(book.getId());
        bookService.deleteBook(book.getId());
//
//        InOrder inOrder = inOrder(replacement, bookrepository);
//        inOrder.verify(replacement).setId(2);
//        inOrder.verify(bookrepository).save(replacement);

    }
}
