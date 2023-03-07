package com.example.klaeffer.web;

import com.example.klaeffer.service.KlaefferService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class KlaefferController {

    private final KlaefferService service;

    public KlaefferController(KlaefferService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/")
    public String addKlaeff(@Valid KlaefferForm klaefferForm){
        service.addKlaeffer(klaefferForm.getName(), klaefferForm.getText());
        return "redirect:/";
    }
}
