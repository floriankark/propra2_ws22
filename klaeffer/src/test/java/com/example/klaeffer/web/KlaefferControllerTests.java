package com.example.klaeffer.web;

import com.example.klaeffer.domain.User;
import com.example.klaeffer.service.KlaefferService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.security.test.context.support.WithMockUser;

import static org.mockito.Mockito.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.oauth2Login;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
public class KlaefferControllerTests {

    private static SecurityMockMvcRequestPostProcessors.OAuth2LoginRequestPostProcessor getOauthWithUser() {
        return oauth2Login().attributes(a -> {
            a.put("login", "jenben300");
            a.put("id", 123);
            a.put("avatar_url", "url");
        });
    }

    @Autowired
    MockMvc mvc;

    @MockBean
    KlaefferService service;

    @Test
    @WithMockUser()
    @DisplayName("Startseite erreichbar")
    void test01()throws Exception{
        mvc.perform(get("/").with(oauth2Login())).andExpect(status().isOk());
    }

    @Test
    @WithMockUser()
    @DisplayName("Kläff hinzufügen")
    void test02() throws Exception {
        String text = "Wilkommen auf Kläffer!";
        User user = new User(123, "jenben300", "url");
        mvc.perform(post("/")
                .with(csrf())
                .with(getOauthWithUser())
                .param("text", text))
                .andExpect(status().is3xxRedirection());
        verify(service).addKlaeffer(user, text);
    }


    @Test
    @WithMockUser()
    @DisplayName("Kläff länger als 300 zeichen nicht hinzufügen")
    void test03() throws Exception {
        String text = "Komm zu Kläffer, der neuen Microblogging Plattform! Während Twitter den Bach runter geht, ermöglicht Kläffer Nutzer:innen das einfache Veröffentlichen von kurzen Texten, genannt Kläffs, mit bis zu 300 Zeichen. Werde Teil der Kläffer-Community und teile deine Gedanken im Internet. Schließe dich jetzt der Bewegung an und melde dich bei Kläffer an - die Zukunft des Microbloggings!";
        assertThat(text.length()).isGreaterThan(300);
        User user = new User(123, "jenben300", "url");
        mvc.perform(post("/")
                .with(csrf())
                .with(getOauthWithUser())
                .param("text", text));
        verify(service, times(0)).addKlaeffer(user, text);
    }

    /*
    @Test
    @WithMockUser()
    @DisplayName("Kläff mit leerem Namen nicht hinzufügen")
    void test04() throws Exception {
        String text = "Wilkommen auf Kläffer!";
        String name = "";
        mvc.perform(post("/"))
                .param("name", name)
                .param("text", text));
        verify(service, times(0)).addKlaeffer(name, text);
    }
    */


    @Test
    @WithMockUser()
    @DisplayName("Kläff mit leerem Text nicht hinzufügen")
    void test05() throws Exception {
        String text = "";
        User user = new User(123, "jenben300", "url");
        mvc.perform(post("/")
                .with(csrf())
                .with(getOauthWithUser())
                .param("text", text));
        verify(service, times(0)).addKlaeffer(user, text);
    }


    @Test
    @DisplayName("Profilseite erreichbar")
    void test06()throws Exception{
        when(service.getUser(123)).thenReturn(new User(123, "jenben300", "url"));
        mvc.perform(get("/profil")
                .with(csrf())
                .with(getOauthWithUser())
                .param("id", "123"))
                .andExpect(status().isOk());
    }

}
