package com.book.bookmanagementt.service;

import com.book.bookmanagementt.entity.Book;
import com.book.bookmanagementt.entity.Category;
import com.book.bookmanagementt.repository.Bookrepository;
import com.book.bookmanagementt.repository.Categoryrepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

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
        List<Category> list = new ArrayList<Category>();
        Category category1 = new Category(1, "first");
        Category category2 = new Category(2, "second");
        list.add(category1);
        list.add(category2);
        when(categoryrepository.findAll()).thenReturn(list);

        List<Category> CategoryList = categoryService.loadAllCategory();

        assertEquals(2, CategoryList.size());


    }

}
