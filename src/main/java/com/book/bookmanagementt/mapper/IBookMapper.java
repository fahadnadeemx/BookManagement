package com.book.bookmanagementt.mapper;

import com.book.bookmanagementt.entity.Book;
import com.book.bookmanagementt.model.BookDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface IBookMapper {
    IBookMapper INSTANCE = Mappers.getMapper(IBookMapper.class);

    //Book to Book DTO
    BookDto mapDto(Book book);

    // Book DTO to Book
    Book map(BookDto bookDto);

    List<BookDto> mapList(List<Book> bookList);
}
