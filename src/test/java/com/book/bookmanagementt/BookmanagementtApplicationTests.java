//package com.book.bookmanagementt;
//
//import com.book.bookmanagementt.entity.Book;
//import com.book.bookmanagementt.repository.Bookrepository;
//import com.book.bookmanagementt.service.BookService;
//
//import static org.assertj.core.api.Assertions.assertThat;  // main one
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
////import org.mockito.InjectMocks;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
////import org.mockito.Mockito;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Arrays;
//import java.util.List;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
//public class BookmanagementtApplicationTests {
//
//    @InjectMocks
//    private BookService bookService;
//
//    @Mock
//    private Bookrepository bookrepository;
//
//    @Before
//    public void init() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//
//    @Test
//    public void test_getAllBooks() {
//        //Arrange
//        Book book1 = new Book(1, "first", "Fahad", 1000);
//        Book book2 = new Book(2, "second", "Nadeem", 5000);
//        Mockito.when(bookrepository.findAll()).thenReturn(Arrays.asList(book1, book2));
//        //Act
//        List<Book> bookList = bookService.getAllBooks();
//        //Assert
//      Assert.assertEquals(2, bookList.size());
//    }
//
//}
//
//
//
//
