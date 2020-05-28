package app;

import java.util.ArrayList;

/**
 *
 * @author Pomeisl Petr
 */
public class Otazka {
    private String Otazka;
    private String[] Odpovedi = new String[3];
    private int SpravnaOdpoved;

    public Otazka() {
    }

    public Otazka(String Otazka, String[] Odpovedi, int SpravnaOdpoved) {
        this.Otazka = Otazka;
        this.Odpovedi = Odpovedi;
        this.SpravnaOdpoved = SpravnaOdpoved;
    }

    public void setOtazka(String Otazka) {
        this.Otazka = Otazka;
    }

    void setOdpovedi(ArrayList<String> Odpovedi) {
        this.Odpovedi = Odpovedi.toArray(new String[0]);
    }

    public void setSpravnaOdpoved(int SpravnaOdpoved) {
        this.SpravnaOdpoved = SpravnaOdpoved;
    }

    public String getOtazka() {
        return Otazka;
    }

    public String[] getOdpovedi() {
        return Odpovedi;
    }

    public int getSpravnaOdpoved() {
        return SpravnaOdpoved;
    }

    @Override
    public String toString() {
        return String.format("%s%n1. %s%n2. %s%n3. %s%n", Otazka, Odpovedi[0], Odpovedi[1],
                Odpovedi[2]);
    }

    
    
    
}
