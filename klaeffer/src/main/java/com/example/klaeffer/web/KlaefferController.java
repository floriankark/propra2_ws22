package com.example.klaeffer.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KlaefferController {

    @GetMapping("/")
    public String startseite(){
        return "index";
    }

}
