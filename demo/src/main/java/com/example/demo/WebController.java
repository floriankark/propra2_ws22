package com.example.demo;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {

    @PostMapping("form")
    public ResponseEntity<String> editForm(@Valid EditForm editForm){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

