package com.example.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class WebControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    @DisplayName("Die Route /form ist vorhanden")
    void test01() throws Exception{
        mvc.perform(post("/form"))
                .andExpect(status().is(not(404)));
    }
}
