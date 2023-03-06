package com.example.blutalkoholwertberechner;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@SessionAttributes({"widmark"})
public class widmarkController {

    @ModelAttribute("widmark")
    public Widmark getWidmark() {
        return new Widmark("m", 0, 0, 0, 0, 0, 0);
    }

    @GetMapping("/")
    public String index(){
        //m.addAttribute("w", new Widmark("m", 0, 0, 0, 0, 0, 0));
        //m.addAttribute("ergebnis", null);
        //m.addAttribute("hatErgebnis", false);
        return "index";
    }

    @GetMapping("/info")
    public String createNameForm() {
        return "index";
    }

    @PostMapping("/info")
    public String widmark(int gewicht, @ModelAttribute("widmark") @Valid Widmark widmark, BindingResult bindingResult, Model m){
        widmark.gewicht(gewicht);
        if (bindingResult.hasErrors()) {
            m.addAttribute("widmark", widmark);
            //m.addAttribute("ergebnis", null);
            //m.addAttribute("hatErgebnis", false);
            return "index";
        }
        m.addAttribute("widmark", widmark);
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
