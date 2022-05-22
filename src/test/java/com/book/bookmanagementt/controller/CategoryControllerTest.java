package com.book.bookmanagementt.controller;


import com.book.bookmanagementt.BookmanagementtApplication;
import com.book.bookmanagementt.entity.Book;
import com.book.bookmanagementt.entity.Category;
import com.book.bookmanagementt.model.BookDto;
import com.book.bookmanagementt.model.CategoryDto;
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
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
    public void testListofCategories() throws Exception {
        List<CategoryDto> CategoryList = new ArrayList<>();
        CategoryList.add(new CategoryDto(1, "first"));
        CategoryList.add(new CategoryDto(2, "second"));
        CategoryList.add(new CategoryDto(3, "third"));
        Mockito.when(categoryService.loadAllCategory()).thenReturn(CategoryList);
        String url = "/categories";
        MvcResult mvcResult = mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();

        String actualJsonResponse = mvcResult.getResponse().getContentAsString();
        System.out.println(actualJsonResponse);

    }

    @Test
    public void testLoadCategoryByIds() throws Exception {
        CategoryDto categoryDto = new CategoryDto(1, "first");

        Mockito.when(categoryService.loadCategoryById(categoryDto.getId())).thenReturn(categoryDto);
        String url = "/categories/find/1";
        MvcResult mvcResult = mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();

        String actualJsonResponse = mvcResult.getResponse().getContentAsString();
        System.out.println(actualJsonResponse);

    }

    @Test
    public void testCreateCategory() throws Exception {

        CategoryDto newCategory = new CategoryDto(1, "first");
        CategoryDto savedCategory = new CategoryDto(2, "");

        Mockito.when(categoryService.saveCategory(newCategory)).thenReturn(savedCategory);
        String url = "/categories/save";

        MockHttpServletResponse response ;
        savedCategory.setName("updated");
        Mockito.when(categoryService.updateCategory(newCategory)).thenReturn(savedCategory);

        response =   mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(savedCategory))).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    public void testUpdateCategory() throws Exception {
        CategoryDto newCategory = new CategoryDto(1, "first");
        CategoryDto savedCategory = new CategoryDto(2, "");

        Mockito.when(categoryService.updateCategory(newCategory)).thenReturn(savedCategory);
        String url = "/categories/update/" + savedCategory.getId();

        MockHttpServletResponse response;

        savedCategory.setName("updated");
        Mockito.when(categoryService.updateCategory(newCategory)).thenReturn(savedCategory);

        response =   mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(savedCategory))).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    public void testCategoryNameMustNotBeBlank() throws Exception {
        categoryService = Mockito.mock(CategoryService.class);
        CategoryDto newCategory = new CategoryDto(1, "first");
        Mockito.when(categoryService.saveCategory(newCategory)).thenReturn(newCategory);
        String url = "/categories/save";

        MockHttpServletResponse response =   mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(newCategory))).andReturn().getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    public void testDeleteBookbyId() throws Exception {

        Category category = new Category(1, "Entertainment");

        doNothing().when(categoryService).deleteCategory(category.getId());
        String url = "/categories/delete/1";
        MockHttpServletResponse response = mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn().getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
}
