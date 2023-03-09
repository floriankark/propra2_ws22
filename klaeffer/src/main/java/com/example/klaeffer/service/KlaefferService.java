package com.example.klaeffer.service;

import com.example.klaeffer.domain.User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;

@Service
public class KlaefferService {

    LinkedList<Klaeffer> klaefferListe = new LinkedList<>();
    HashMap<Integer, User> users = new HashMap<>();

    public void addKlaeffer(User user, String text) {
        users.put(user.getId(), user);
        klaefferListe.addFirst(new Klaeffer(user, text));
    }

    public LinkedList<Klaeffer> getKlaeffer(){
        return klaefferListe;
    }

    public User getUser(Integer id){
        return users.get(id);
    }
}
