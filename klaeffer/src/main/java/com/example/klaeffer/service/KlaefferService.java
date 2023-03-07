package com.example.klaeffer.service;

import org.springframework.stereotype.Service;

@Service
public class KlaefferService {

    public Klaeffer addKlaeffer(String name, String text) {
        return new Klaeffer(name, text);
    }
}
