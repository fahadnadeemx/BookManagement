package com.book.bookmanagementt.service;

import com.book.bookmanagementt.entity.Book;
import com.book.bookmanagementt.mapper.IBookMapper;
import com.book.bookmanagementt.model.BookDto;
import com.book.bookmanagementt.repository.Bookrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {

    @Autowired
    public Bookrepository bookrepository;

    private static final IBookMapper bookMapper = IBookMapper.INSTANCE;

    public BookService(Bookrepository bookrepository) {
        this.bookrepository = bookrepository;
    }

    @Override
    public List<BookDto> loadAllBooks() {
        List<Book> books = bookrepository.findAll();
        return bookMapper.mapList(books);
    }

    @Override
    public Optional<BookDto> loadBookById(int id) {
        Optional<Book> book = bookrepository.findById(id);
        if (book.isPresent()) {
            return Optional.ofNullable(bookMapper.mapDto(book.get()));
        }
        return Optional.empty();
    }

    @Override
    public BookDto saveBook(BookDto book) {
        Book booksaved = bookrepository.save(bookMapper.map(book));
        return bookMapper.mapDto(booksaved);
    }

    @Override
    public BookDto updateBook(int id, BookDto book) {
        book.setId(id);

        Book res = bookMapper.map(book);
        Book booksaved = bookrepository.save(res);
        return bookMapper.mapDto(booksaved);
    }

    @Override
    public void deleteBook(int id) {
        bookrepository.deleteById(id);
    }
}