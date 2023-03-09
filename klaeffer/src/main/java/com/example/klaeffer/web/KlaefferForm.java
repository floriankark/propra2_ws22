package com.example.klaeffer.web;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class KlaefferForm {

    String name;

    @NotBlank(message = "Nicht vergessen zu Bellen *Wau Rrr*")
    @Length(min = 0, max = 300, message = "Das ist zu viel Gebelle! Weniger als 300 Zeichen bitte!")
    String text;

    public KlaefferForm(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
