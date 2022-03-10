//package com.book.bookmanagementt;
//
//import com.book.bookmanagementt.entity.Book;
//import com.book.bookmanagementt.repository.Bookrepository;
//import com.book.bookmanagementt.service.BookService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.context.annotation.Import;
//import org.springframework.test.context.junit4.SpringRunner;
//import static org.assertj.core.api.Assertions.*;
//@RunWith(SpringRunner.class)
//@DataJpaTest
//@Import(BookService.class)
//public class BookServiceRepositoryIT {
//    @Autowired
//    private BookService bookService;
//    @Autowired
//    private Bookrepository bookrepository;
//    @Test
//    public void testServiceCanInsertIntoRepository() {
//        Book saved = bookService
//                .saveBook(new Book(1, "A book","Fahad", 1000));
//        bookrepository.findById(saved.getId()).isPresent();
//    }
//    @Test
//    public void testServiceCanUpdateIntoRepository() {
//        Book saved = bookService
//                .saveBook(new Book(1, "A book","Fahad", 1000));
//        Book modified = bookService.
//                updateBook(saved.getId(),
//                        new Book(1, "A book modified","Fahad", 1000));
//        assertThat(bookrepository.findById(saved.getId()).get())
//                .isEqualTo(modified);
//    }
//}
