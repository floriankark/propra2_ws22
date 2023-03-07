package com.example.klaeffer.web;

import com.example.klaeffer.service.KlaefferService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class KlaefferController {

    private final KlaefferService service;

    public KlaefferController(KlaefferService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index(Model m){
        m.addAttribute("klaefferForm", new KlaefferForm("", ""));
        return "index";
    }

    @PostMapping("/")
    public String addKlaeff(@Valid KlaefferForm klaefferForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "index";
        }
        service.addKlaeffer(klaefferForm.getName(), klaefferForm.getText());
        return "redirect:/";
    }
}
