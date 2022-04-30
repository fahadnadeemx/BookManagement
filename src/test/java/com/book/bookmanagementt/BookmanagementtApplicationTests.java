//package com.book.bookmanagementt;
//
//import com.book.bookmanagementt.entity.Book;
//import com.book.bookmanagementt.repository.Bookrepository;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.reactive.server.WebTestClient;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.Assert.assertEquals;
//import static org.springframework.http.RequestEntity.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class BookmanagementtApplicationTests {
//
//    @LocalServerPort
//    private int port;
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//
//    @Test
//    public void shouldPassIfStringMatches() throws Exception {
//        Book book = new Book();
//        book.setId(1);
//        book.setBookname("Marvels");
//        book.setAuthor("Fahad Nadeem");
//        book.setPrice(1000);
//        assertThat(restTemplate.getForObject("http://localhost:" + port + "/books/1",
//                String.class)).contains(book.getId());
//    }
////
////    @Autowired
////    BookController bookController;
////    @Test
////    void contextLoads() {
////        assertNotNull(bookController);
////    }
////
////}
//
//
//
////    @Autowired
////    private MockMvc mockMvc;
////
////    @Autowired
////    private ObjectMapper objectMapper;
////
////    @Autowired
////    private Bookrepository bookrepository;
//
////    @Test
////    public void registrationWorksThroughAllLayers() throws Exception {
////        Book book = new Book();
////        book.setId(1);
////        book.setBookname("Marvels");
////        book.setAuthor("Fahad Nadeem");
////        book.setPrice(1000);
////
////        String url = "/books/save";
////
////        mockMvc.perform(MockMvcRequestBuilders.post(url)
////                .contentType(MediaType.APPLICATION_JSON)
////                .accept(MediaType.APPLICATION_JSON)
////                .content(this.objectMapper.writeValueAsString(book)))
////                .andExpect(status().isOk());
////
////        Optional<Book> resultant = bookrepository.findById(111);
////        assertEquals(book, resultant);
////        Optional<Book> result = bookrepository.findById(111);
////        assertThat(result.).isEqualTo("Zophod");
//    }
//
