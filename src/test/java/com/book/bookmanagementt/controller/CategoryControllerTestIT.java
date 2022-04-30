package com.book.bookmanagementt.controller;
import com.book.bookmanagementt.BookmanagementtApplication;
import com.book.bookmanagementt.entity.Category;
import static io.restassured.RestAssured.*;
import com.book.bookmanagementt.repository.Categoryrepository;
import com.book.bookmanagementt.service.BookService;
import com.book.bookmanagementt.service.CategoryService;
import com.book.bookmanagementt.service.ICategoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import java.net.URI;
import java.util.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.inject.Inject;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@SpringBootTest(classes = BookmanagementtApplication.class)
public class CategoryControllerTestIT {

    private MockMvc mockMvc;

    @Autowired
    private Categoryrepository categoryrepository;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ICategoryService categoryService;

    @InjectMocks
    private CategoryController categoryController;

    @Before
    public void setup() {
        RestAssured.port = port;
        // always start with an empty database
        categoryrepository.deleteAll();
        categoryrepository.flush();

        mockMvc = MockMvcBuilders.standaloneSetup(categoryController).build();
    }


    @Test
    public void test_createNewCategory() throws Exception {
        Category category = new Category();
        category.setId(1);
        category.setName("Entertainment");
        TestRestTemplate restTemplate=new TestRestTemplate();
        final String url = "/categories/save";
        ObjectMapper objectMapper=new ObjectMapper();
        final String baseUrl = "http://localhost:8080/categories/save";
        URI uri = new URI(baseUrl);
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");
        HttpEntity<Category> request = new HttpEntity<>(category, headers);
        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
        Optional<Category> ex = categoryrepository.findById(category.getId());
//        mockMvc.perform(post(url)
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(category)));

        assertEquals(category.getName(), ex.get().getName());

    }

    @Test
    public void test_getallCategory() throws Exception {
        Category category = new Category();
        category.setId(1);
        category.setName("Entertainment");
        List<Category> allCategory= List.of(category);

        categoryrepository.saveAll(allCategory);
        // when
        when().get("/categories");

        assertEquals(1, categoryrepository.findAll().size());

    }
    @Test
    public void test_deleteCategory() throws Exception {

        // given
        Category category = new Category();
        category.setId(1);
        category.setName("Entertainment");

        List<Category> allCategory= List.of(category);

        categoryrepository.saveAll(allCategory);

        // when
        when().delete("/categories/delete/" + category.getId());

        assertEquals(1, categoryrepository.findAll().size());

    }



}
