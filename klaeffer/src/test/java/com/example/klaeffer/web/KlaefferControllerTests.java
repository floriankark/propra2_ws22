package com.example.klaeffer.web;

import com.example.klaeffer.service.KlaefferService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
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
    void test02() throws Exception {
        String text = "Wilkommen auf Kläffer!";
        String name = "Flo";
        mvc.perform(post("/")
                .param("name", name)
                .param("text", text))
                .andExpect(status().is3xxRedirection());
        verify(service).addKlaeffer(name, text);
    }

    @Test
    @DisplayName("Kläff länger als 300 zeichen nicht hinzufügen")
    void test03() throws Exception {
        String text = "Komm zu Kläffer, der neuen Microblogging Plattform! Während Twitter den Bach runter geht, ermöglicht Kläffer Nutzer:innen das einfache Veröffentlichen von kurzen Texten, genannt Kläffs, mit bis zu 300 Zeichen. Werde Teil der Kläffer-Community und teile deine Gedanken im Internet. Schließe dich jetzt der Bewegung an und melde dich bei Kläffer an - die Zukunft des Microbloggings!";
        assertThat(text.length()).isGreaterThan(300);
        String name = "Flo";
        mvc.perform(post("/")
                .param("name", name)
                .param("text", text))
                .andExpect(status().is3xxRedirection());
        verify(service, times(0)).addKlaeffer(name, text);
    }

    @Test
    @DisplayName("Kläff mit leerem Namen nicht hinzufügen")
    void test04() throws Exception {
        String text = "Wilkommen auf Kläffer!";
        String name = "";
        mvc.perform(post("/")
                .param("name", name)
                .param("text", text))
                .andExpect(status().is3xxRedirection());
        verify(service, times(0)).addKlaeffer(name, text);
    }

    @Test
    @DisplayName("Kläff mit leerem Text nicht hinzufügen")
    void test05() throws Exception {
        String text = "";
        String name = "Flo";
        mvc.perform(post("/")
                .param("name", name)
                .param("text", text))
                .andExpect(status().is3xxRedirection());
        verify(service, times(0)).addKlaeffer(name, text);
    }
}
