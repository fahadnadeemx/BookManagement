package com.book.bookmanagementt.controller;


import com.book.bookmanagementt.BookmanagementtApplication;
import com.book.bookmanagementt.entity.Book;
import com.book.bookmanagementt.entity.Category;
import com.book.bookmanagementt.service.BookService;
import com.book.bookmanagementt.service.CategoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.ArrayList;
import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BookmanagementtApplication.class)
public class CategoryControllerTest{
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Mock
    private CategoryService categoryService;

    @InjectMocks
    private CategoryController categoryController;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(categoryController).build();
    }

    @Test
    public void testListofBooks() throws Exception {
        List<Category> CategoryList = new ArrayList<>();
        CategoryList.add(new Category(1, "first"));
        CategoryList.add(new Category(2, "second"));
        CategoryList.add(new Category(3, "third"));
        Mockito.when(categoryService.loadAllCategory()).thenReturn(CategoryList);
        String url = "/categories";
        MvcResult mvcResult = mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();

        String actualJsonResponse = mvcResult.getResponse().getContentAsString();
        System.out.println(actualJsonResponse);

    }

    @Test
    public void testCreateBook() throws Exception {

        Category newCategory = new Category(1, "first");
        Category savedCategory = new Category(2, "second");

        Mockito.when(categoryService.saveCategory(newCategory)).thenReturn(savedCategory);
        String url = "/categories/save";
//        mockMvc.perform(post(url).contentType("application/json")
//                        .param("id", String.valueOf(newCategory.getId()))
//                        .param("name", newCategory.getName())).
//                andExpect(status().isOk());
        mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(savedCategory)));

        Mockito.verify(categoryService, Mockito.times(0)).saveCategory(newCategory);
    }

    @Test
    public void testUpdateBook() throws Exception {

        Category newCategory = new Category(1, "first");
        Category savedCategory = new Category(2, "second");

        Mockito.when(categoryService.updateCategory(newCategory)).thenReturn(savedCategory);
        String url = "/categories/update/" + savedCategory.getId();
//        mockMvc.perform(put(url).contentType("application/json")
//                        .param("id", String.valueOf(savedCategory.getId()))
//                        .param("name", savedCategory.getName())).
//                andExpect(status().isOk());
        mockMvc.perform(put(url)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(savedCategory)));

        Mockito.verify(categoryService, Mockito.times(0)).saveCategory(newCategory);
    }

    @Test
    public void testBookNameMustNotBeBlank() throws Exception {
        categoryService = Mockito.mock(CategoryService.class);
        Category newCategory = new Category(1, "first");
        Mockito.when(categoryService.saveCategory(newCategory)).thenReturn(newCategory);
        String url = "/categories/save";
//        mockMvc.perform(post(url).contentType(MediaType.APPLICATION_FORM_URLENCODED)
//                        .param("name", "")
//                        .param("name", newCategory.getName()))
//                .andExpect(status().isBadRequest());
        mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(newCategory)));

    }


}
