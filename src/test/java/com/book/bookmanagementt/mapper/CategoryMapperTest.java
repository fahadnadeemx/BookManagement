package com.book.bookmanagementt.mapper;

import com.book.bookmanagementt.entity.Category;
import com.book.bookmanagementt.model.CategoryDto;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CategoryMapperTest {
    public static final int id = 1;
    public static final String name = "Entertainment";

    ICategoryMapper categoryMapper = ICategoryMapper.INSTANCE;

    @Test
    public void CategorytoCategoryDtoReturnsNull() {
        assertNull(categoryMapper.mapDto(null));
    }

    @Test
    public void CategoryToCategoryDtoReturnsEmptyObject() {
        assertNotNull(categoryMapper.mapDto(new Category()));
    }

    @Test
    public void CategoryToCategoryDto() {
        // given
        Category category = new Category();
        category.setId(id);
        category.setName(name);

        //when
        CategoryDto categoryDto = categoryMapper.mapDto(category);

        //then
        assertNotNull(categoryDto);
        assertEquals(id, categoryDto.getId());
        assertEquals(name, categoryDto.getName());


    }

    @Test
    public void CategoryDtoToCategorysReturnsNull() {
        assertNull(categoryMapper.map(null));
    }

    @Test
    public void CategoryDtoToCategoryReturnsEmptyObject() {
        assertNotNull(categoryMapper.map(new CategoryDto()));
    }

    @Test
    public void CategoryDtoToCategory() {
        // given

        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(id);
        categoryDto.setName(name);


        //when
        Category category = categoryMapper.map(categoryDto);
        //then
        assertNotNull(category);
        assertEquals(id, category.getId());
        assertEquals(name, category.getName());

    }

    @Test
    public void toCategoryDtoReturnsNull() {
        assertNull(categoryMapper.mapList(null));
    }

    @Test
    public void toCategoryDtoReturnsEmptyObject() {
        List<Category> categoryList = new ArrayList<>(Arrays.asList());

        assertNotNull(categoryMapper.mapList(categoryList));
    }

    @Test
    public void toCategoryDto() {
        // given
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "first"));
        categoryList.add(new Category(2, "second"));
        categoryList.add(new Category(3, "third"));

        //when
        List<CategoryDto> categoryDtos = categoryMapper.mapList(categoryList);

        //then
        assertEquals(3,categoryDtos.size());
        assertNotNull(categoryDtos);
    }
}

