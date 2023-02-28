package com.example.blutalkoholwertberechner;

import org.springframework.web.bind.annotation.RequestParam;

public record Widmark(
        @RequestParam("geschlecht") String geschlecht,
        int gewicht,
        int bier,
        int wein,
        int korn,
        int vodka,
        int whiskey
) {
    public double getWidmark(){
        double A = (bier*0.05 + wein*0.12 + korn*0.32 + vodka*0.4 + whiskey*0.43)*0.8;
        double r = geschlecht.equals("m") ? 0.7 : 0.6;
        return A / (gewicht * r);
    }
}
