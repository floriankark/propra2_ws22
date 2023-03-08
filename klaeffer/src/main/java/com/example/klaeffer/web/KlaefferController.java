package com.example.klaeffer.web;

import com.example.klaeffer.service.KlaefferService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class KlaefferController {

    private final KlaefferService service;

    public KlaefferController(KlaefferService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index(KlaefferForm klaefferForm, Model m){
        m.addAttribute("klaeffer", service.getKlaeffer());
        return "index";
    }

    @PostMapping("/")
    public String addKlaeff(@Valid KlaefferForm klaefferForm, BindingResult bindingResult, RedirectAttributes attrs){
        if (bindingResult.hasErrors()){
            return "index";
        }
        service.addKlaeffer(klaefferForm.getName(), klaefferForm.getText());
        attrs.addFlashAttribute("klaefferForm", klaefferForm);
        return "redirect:/";
    }
}
