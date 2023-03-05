package com.example.demo;

//import javax.validation.Valid;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

@Controller
public class WebController {

    @GetMapping("/")
    public String index(){
        return "form";
    }

    @PostMapping("form")
    public String editForm(@Valid EditForm editForm, Model m){
        m.addAttribute("text", editForm.text());
        return "form";
    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String handleConstraintViolationException(BindException e) {
        return "form";
    }
}

