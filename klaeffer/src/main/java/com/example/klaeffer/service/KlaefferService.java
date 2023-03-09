package com.example.klaeffer.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;

@Service
public class KlaefferService {

    LinkedList<Klaeffer> klaefferListe = new LinkedList<>();

    public void addKlaeffer(String name, String text) {
         klaefferListe.addFirst(new Klaeffer(name, text));
    }

    public LinkedList<Klaeffer> getKlaeffer(){
        return klaefferListe;
    }
}
