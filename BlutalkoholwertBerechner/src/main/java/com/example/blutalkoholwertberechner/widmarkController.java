package com.example.blutalkoholwertberechner;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class widmarkController {
    @GetMapping("/")
    public String index(Model m){
        m.addAttribute("w", null);
        m.addAttribute("ergebnis", null);
        m.addAttribute("hatErgebnis", false);
        return "index";
    }

    @PostMapping("/")
    public String widmark(@Valid Widmark w, BindingResult bindingResult, Model m){
        if (bindingResult.hasErrors()) {
            return "index";
        }
        m.addAttribute("w", w);
        m.addAttribute("ergebnis", String.format("%.2f", w.getWidmark()));
        m.addAttribute("hatErgebnis", true);
        return "index";
    }
}
