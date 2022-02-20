package com.book.bookmanagementt.controller;

import com.book.bookmanagementt.entity.Book;
import com.book.bookmanagementt.repository.Bookrepository;
import com.book.bookmanagementt.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = com.example.recipe.recipeapp.controller.BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

//    Book mockbook = new Book(1, "first", "Fahad", 1000);

//    String exampleBookJson = "{\"id\":\"1\",\"bookname\":\"first\",\"author\":\"Fahad\",\"price\":[\"1000\"]}";

//    @Test
//    public void createStudentCourse() {
//        Book mockCourse = new Book( 1, "Smallest","Number", 100,
//                Arrays.asList("1", "2", "3", "4"));
//
//        // studentService.addCourse to respond back with mockCourse
//        Mockito.when(
//                bookService.saveBook(Mockito.anyString(),
//                        Mockito.any(Book.class))).thenReturn(mockCourse);
//
//        // Send course as body to /students/Student1/courses
//        RequestBuilder requestBuilder = MockMvcRequestBuilders
//                .post("/books/save")
//                .accept(MediaType.APPLICATION_JSON).content(exampleCourseJson)
//                .contentType(MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//
//        MockHttpServletResponse response = result.getResponse();
//
//        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
//
//        assertEquals("http://localhost/books/save/1",
//                response.getHeader(HttpHeaders.LOCATION));
//
//    }
//@RunWith(SpringRunner.class)
//@WebMvcTest(controllers = com.example.recipe.recipeapp.controller.BookController.class)
//public class BookControllerTest {
//    @Autowired
//    private MockMvc mvc;
//
//    @MockBean
//    private BookService bookService;
//
////    @Test
////    public void testAllEmployeesNotEmpty() throws Exception {
////        List<Book> list = new ArrayList<Book>();
////        Book book1 = new Book(1, "first", "Fahad", 1000);
////        Book book2 = new Book(2, "second", "Nadeem", 5000);
////        Mockito.when(bookService.loadAllBooks()).
////                thenReturn(list);
////        this.mvc.perform(get("/api/employees")
////                        .accept(MediaType.APPLICATION_JSON))
////                .andExpect(status().isOk())
////                .andExpect(jsonPath("$[0].id", is(1)))
////                .andExpect(jsonPath("$[0].name", is("first")))
////                .andExpect(jsonPath("$[0].salary", is(1000)))
////                .andExpect(jsonPath("$[1].id", is(2)))
////                .andExpect(jsonPath("$[1].name", is("second")))
////                .andExpect(jsonPath("$[1].salary", is(5000)));
////    }
//@Test
//public void createRecord_success() throws Exception {
//    Bookrepository record = bookService.saveBook()
//            .bookname("John Doe")
//            .price(47)
//            .author("New York USA")
//            .build();
//
//    Mockito.when(bookrepository.save(record)).thenReturn(record);
//
//    MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/patient")
//            .contentType(MediaType.APPLICATION_JSON)
//            .accept(MediaType.APPLICATION_JSON)
//            .content(this.mapper.writeValueAsString(record));
//
//    mockMvc.perform(mockRequest)
//            .andExpect(status().isOk())
//            .andExpect(jsonPath("$", notNullValue()))
//            .andExpect(jsonPath("$.name", is("John Doe")));
//}
//}