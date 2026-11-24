package com.example.formularze;

import java.util.Calendar;

public class Osoba {
    private String imie;
    private Calendar dataUrodzenia;

    public Osoba(String imie, Calendar dataUrodzenia) {
        this.imie = imie;
        this.dataUrodzenia = dataUrodzenia;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public Calendar getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(Calendar dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }
}
