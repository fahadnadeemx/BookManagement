package com.book.bookmanagementt.service;


import com.book.bookmanagementt.entity.Category;
import com.book.bookmanagementt.model.CategoryDto;
import com.book.bookmanagementt.repository.Categoryrepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CategoryServiceTest {

    @InjectMocks
    private CategoryService categoryService;

    @Mock
    private Categoryrepository categoryrepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_getAllCategory() {
        List<Category> list = new ArrayList<>();
        Category category1 = new Category(1, "first");
        Category category2 = new Category(2, "second");
        list.add(category1);
        list.add(category2);
        when(categoryrepository.findAll()).thenReturn(list);

        List<CategoryDto> CategoryList = categoryService.loadAllCategory();

        assertEquals(2, CategoryList.size());

    }

    @Test
    public void test_getCategoryById() {
        CategoryDto categoryDto = categoryService.loadCategoryById(1);
        assertEquals(0, categoryDto.getId());
        assertNull(categoryDto.getName());
        //Arrange
        Category category1 = new Category(1, "first");
        when(categoryrepository.findById(1)).thenReturn(Optional.of(category1));

        CategoryDto categoryList = categoryService.loadCategoryById(1);
        assertEquals(1, categoryList.getId());

    }

    @Test
    public void SaveCategory() {
        Category replaced = new Category(2, "saved");
        CategoryDto categoryreplaced = new CategoryDto(2, "saved");
        when(categoryrepository.save(any(Category.class)))
                .thenReturn(replaced);

        CategoryDto categoryList = categoryService.saveCategory(categoryreplaced);
        assertEquals(categoryreplaced, categoryList);
    }

    @Test
    public void test_updatecategory() {
        CategoryDto replacement = spy(new CategoryDto(1, "first"));
        Category replaced = new Category(2, "saved");
        CategoryDto categoryreplaced = new CategoryDto(2, "saved");

        when(categoryrepository.save(any(Category.class)))
                .thenReturn(replaced);
        CategoryDto categoryList = categoryService.updateCategory(replacement);
        assertEquals(categoryreplaced, categoryList);
    }

    @Test
    public void testDeleteCategoryById_found() {
        //Arrange
        doNothing().when(categoryrepository).deleteById(1);
        categoryService.deleteCategory(1);

        Category category = categoryrepository.getById(1);
        assertNull(category);
    }
}

