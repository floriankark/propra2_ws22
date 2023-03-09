package com.example.klaeffer.web;

import com.example.klaeffer.domain.User;
import com.example.klaeffer.service.KlaefferService;
import jakarta.validation.Valid;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Objects;

@Controller
public class KlaefferController {

    private final KlaefferService service;

    public KlaefferController(KlaefferService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index(KlaefferForm klaefferForm, Model m, OAuth2AuthenticationToken auth){
        klaefferForm.setName(auth.getPrincipal().getAttribute("login"));
        m.addAttribute("klaeffer", service.getKlaeffer());
        return "index";
    }

    @PostMapping("/")
    public String addKlaeff(@Valid KlaefferForm klaefferForm, BindingResult bindingResult, RedirectAttributes attrs, OAuth2AuthenticationToken auth){
        klaefferForm.setName(auth.getPrincipal().getAttribute("login"));

        if (bindingResult.hasErrors()){
            return "index";
        }

        User user = new User(auth.getPrincipal().getAttribute("id"),
                auth.getPrincipal().getAttribute("login"),
                auth.getPrincipal().getAttribute("avatar_url"));

        service.addKlaeffer(user, klaefferForm.getText());
        attrs.addFlashAttribute("klaefferForm", klaefferForm);
        return "redirect:/";
    }

    @GetMapping("/profil")
    public String showProfile(Integer id, Model m){
        m.addAttribute("user", service.getUser(id));
        return "profil";
    }
}
