package com.book.bookmanagementt.mapper;

import com.book.bookmanagementt.entity.Book;
import com.book.bookmanagementt.entity.Category;
import com.book.bookmanagementt.model.BookDto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

 class BookMapperTest {
    public static final int id = 1;
    public static final String bookname = "First Book";
    public static final String author = "Fahad Nadeem";
    public static final int price = 100;
    Category category = new Category(1, "Entertainment");

    IBookMapper bookMapper = IBookMapper.INSTANCE;

    @Test
    void booktobookDtoReturnsNull() {
        assertNull(bookMapper.mapDto(null));
    }

    @Test
    void booksTobooksDtoReturnsEmptyObject() {
        assertNotNull(bookMapper.mapDto(new Book()));
    }

    @Test
    void BooksToBooksDto() {
        // given
        Book book = new Book();
        book.setId(id);
        book.setBookname(bookname);
        book.setAuthor(author);
        book.setPrice(price);
        book.setCategory(category);

        //when
        BookDto bookDto = bookMapper.mapDto(book);

        //then
        assertNotNull(bookDto);
        assertEquals(id, bookDto.getId());
        assertEquals(bookname, bookDto.getBookname());
        assertEquals(author, bookDto.getAuthor());
        assertEquals(price, bookDto.getPrice());
        assertEquals(category, bookDto.getCategory());

    }

    @Test
    void booksDtoToBooksReturnsNull() {
        assertNull(bookMapper.map(null));
    }

    @Test
    void booksDtoToUsersReturnsEmptyObject() {
        assertNotNull(bookMapper.map(new BookDto()));
    }

    @Test
    void BooksDtoToBooks() {
        // given

        BookDto bookDto = new BookDto();
        bookDto.setId(id);
        bookDto.setBookname(bookname);
        bookDto.setAuthor(author);
        bookDto.setPrice(price);
        bookDto.setCategory(category);

        //when
        Book book = bookMapper.map(bookDto);
        //then
        assertNotNull(book);
        assertEquals(id, book.getId());
        assertEquals(bookname, book.getBookname());
        assertEquals(author, book.getAuthor());
        assertEquals(price, book.getPrice());
        assertEquals(category, book.getCategory());

    }

    @Test
    void toBookDtoReturnsNull() {
        assertNull(bookMapper.mapList(null));
    }

    @Test
    void toBookDtoReturnsEmptyObject() {
        List<Book> bookList = new ArrayList<>(Arrays.asList());

        assertNotNull(bookMapper.mapList(bookList));
    }

    @Test
    void toBookDto() {
        // given
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(1, "first", "first", 10, category));
        bookList.add(new Book(2, "second", "first", 20, category));
        bookList.add(new Book(3, "third", "first", 30, category));

        //when
        List<BookDto> bookDtos = bookMapper.mapList(bookList);

        //then
        assertEquals(3,bookDtos.size());
        assertNotNull(bookDtos);
    }
}

