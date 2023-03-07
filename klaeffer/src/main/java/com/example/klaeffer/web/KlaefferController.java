package com.example.klaeffer.web;

import com.example.klaeffer.service.KlaefferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String addKlaeff(String name, String text){
        System.out.println(name);
        service.addKlaeffer(name, text);
        return "redirect:/";
    }

}
