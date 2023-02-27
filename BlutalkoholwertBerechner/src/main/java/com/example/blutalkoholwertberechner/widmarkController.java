package com.example.blutalkoholwertberechner;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class widmarkController {
    @GetMapping("berechnen")
    public @ResponseBody
    double widmark(Widmark w){
        return w.getWidmark();
    }
}
