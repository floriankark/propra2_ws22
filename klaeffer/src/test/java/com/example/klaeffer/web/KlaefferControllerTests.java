package com.example.klaeffer.web;

import com.example.klaeffer.service.KlaefferService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class KlaefferControllerTests {

    @Autowired
    MockMvc mvc;

    @MockBean
    KlaefferService service;

    @Test
    @DisplayName("Startseite erreichbar")
    void test01()throws Exception{
        mvc.perform(get("/")).andExpect(status().isOk());
    }

    @Test
    @DisplayName("Kläff hinzufügen")
    void test_validation4() throws Exception {
        String text = "Wilkommen auf Kläffer!";
        String name = "Flo";
        mvc.perform(post("/")
                .param("name", name)
                .param("text", text))
                .andExpect(status().is3xxRedirection());
        verify(service).addKlaeffer(name, text);
    }
}
