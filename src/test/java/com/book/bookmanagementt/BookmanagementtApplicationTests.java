package com.book.bookmanagementt;

import com.book.bookmanagementt.entity.Book;
import com.book.bookmanagementt.repository.Bookrepository;
import com.book.bookmanagementt.service.BookService;
import static org.assertj.core.api.Assertions.assertThat;  // main one
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookmanagementtApplicationTests {

    @Mock
    private Bookrepository bookrepository;
    @InjectMocks
    private BookService bookService;

    @Test
    public void test_getAllBooks() {
        Book book1 = new Book(1, "first", "Fahad",  1000);
        Book book2 = new Book(2, "second", "Nadeem", 5000);
        when(Bookrepository.findAll()).
                thenReturn(Arrays.asList(book1,book2));
        assertThat(BookService.getAllBooks()).contains(book1,book2);
    }

}




