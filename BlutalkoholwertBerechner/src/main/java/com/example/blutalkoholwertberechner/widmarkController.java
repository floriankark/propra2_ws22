package com.example.blutalkoholwertberechner;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class widmarkController {
    @GetMapping("/")
    public String index(Model m){
        m.addAttribute("ergebnis", null);
        m.addAttribute("hatErgebnis", false);
        return "index";
    }

    @PostMapping("/")
    public String widmark(Widmark w, Model m){
        m.addAttribute("ergebnis", w.getWidmark());
        m.addAttribute("hatErgebnis", true);
        return "index";
    }
}
