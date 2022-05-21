package com.book.bookmanagementt.mapper;

import com.book.bookmanagementt.entity.Category;
import com.book.bookmanagementt.model.CategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface ICategoryMapper {
    ICategoryMapper INSTANCE = Mappers.getMapper(ICategoryMapper.class);
    //Category to Category DTO
    CategoryDto mapDto(Category category);
    // Category DTO to Category
    Category map(CategoryDto categoryDto);

    List<CategoryDto> mapList(List<Category> categoryList);
}
