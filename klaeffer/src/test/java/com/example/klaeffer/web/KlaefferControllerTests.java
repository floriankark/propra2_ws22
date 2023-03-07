package com.example.klaeffer.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class KlaefferControllerTests {

    @Autowired
    MockMvc mvc;

    @Test
    @DisplayName("Startseite erreichbar")
    void test01()throws Exception{
        mvc.perform(get("/")).andExpect(status().isOk());
    }
}
