package com.example.blutalkoholwertberechner;

import jakarta.validation.constraints.Min;
import org.springframework.web.bind.annotation.RequestParam;

public class Widmark {

    /*
    UMSCHREIBEN ZU KLASSE DAMIT ATTRIBUTE MUTABLE SIND UND ÜBERSCHRIEBEN WERDEN KÖNNEN -> ERLAUBT SESSION ATTRIBUTES
     */

    /*
    @RequestParam("geschlecht") String geschlecht,
    @Min(value = 30, message = "Sie müssen min. 30 Kg wiegen") int gewicht,
    @Min(value = 0, message = "Negative Werte sind nicht erlaubt!") int bier,
    @Min(value = 0, message = "Negative Werte sind nicht erlaubt!") int wein,
    @Min(value = 0, message = "Negative Werte sind nicht erlaubt!") int korn,
    @Min(value = 0, message = "Negative Werte sind nicht erlaubt!") int vodka,
    @Min(value = 0, message = "Negative Werte sind nicht erlaubt!") int whiskey
     */

    private String geschlecht;
    private int gewicht;


    public double getWidmark(){
        double A = (bier*0.05 + wein*0.12 + korn*0.32 + vodka*0.4 + whiskey*0.43)*0.8;
        double r = geschlecht.equals("m") ? 0.7 : 0.6;
        return A / (gewicht * r) * 0.7;
    }
    /*
    !!Hinzufügen:
    Als stündlicher Abbauwert ist ein Wert zwischen 0,1 ‰ und 0,2 ‰ anzunehmen.
    In der forensischen Literatur geht man auch von einer Abbaurate von ca. 0,15 ‰ aus.
    Aufgabe wäre auszurechnen und auszugeben wann man wieder nüchtern ist.
     */
}
