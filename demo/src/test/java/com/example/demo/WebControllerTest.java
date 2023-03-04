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

    @Test
    @DisplayName("Wenn kein Text vorhanden ist, dann erzeugen wir einen Bad Request")
    void test02() throws Exception {
        mvc.perform(post("/form"))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Wenn ein Text vorhanden ist, dann erzeugen wir als Antwort ein OK")
    void test03() throws Exception {
        mvc.perform(post("/form").param("text", "Das ist ein Text"))
                .andExpect(status().isOk());
    }

}
