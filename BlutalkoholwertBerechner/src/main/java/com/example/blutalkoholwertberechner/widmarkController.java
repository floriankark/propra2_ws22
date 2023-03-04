package com.example.blutalkoholwertberechner;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@SessionAttributes({"geschlecht", "gewicht"})
public class widmarkController {
    @GetMapping("/")
    public String index(Model m){
        m.addAttribute("w", new Widmark("m", 0, 0, 0, 0, 0, 0));
        m.addAttribute("ergebnis", null);
        m.addAttribute("hatErgebnis", false);
        return "index";
    }

    @PostMapping("/")
    public String widmark(@ModelAttribute("w") @Valid Widmark w, BindingResult bindingResult, Model m){
        if (bindingResult.hasErrors()) {
            m.addAttribute("w", w);
            //m.addAttribute("ergebnis", null);
            //m.addAttribute("hatErgebnis", false);
            return "index";
        }
        m.addAttribute("w", w);
        //m.addAttribute("ergebnis", w.getWidmark());
        //m.addAttribute("hatErgebnis", true);
        return "rechner";
    }

    @PostMapping("/rechner")
    public String ergebnis(@ModelAttribute("w") @Valid Widmark w, BindingResult bindingResult, Model m){
        if (bindingResult.hasErrors()) {
            m.addAttribute("w", w);
            m.addAttribute("ergebnis", null);
            m.addAttribute("hatErgebnis", false);
            return "rechner";
        }
        m.addAttribute("w", w);
        m.addAttribute("ergebnis", w.getWidmark());
        m.addAttribute("hatErgebnis", true);
        return "rechner";
    }
}
