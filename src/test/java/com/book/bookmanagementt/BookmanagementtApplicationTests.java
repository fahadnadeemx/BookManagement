package com.book.bookmanagementt;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BookmanagementtApplicationTests {
    @Test
    public void contextLoads() {
        assertTrue(true);
    }

}

