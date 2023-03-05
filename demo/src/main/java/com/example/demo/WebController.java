package com.example.demo;

//import javax.validation.Valid;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.HtmlUtils;

@Controller
public class WebController {

    @PostMapping("form")
    public ResponseEntity<String> editForm(@Valid EditForm editForm){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String handleConstraintViolationException(BindException e) {
        return "dummy";
    }
}

