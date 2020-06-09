package app;

import java.util.ArrayList;
import java.util.List;

/**
 * Reprezentuje jednotlivé otázky v testu.
 * @author Pomeisl Petr
 */
public class Otazka {

    private String otazka;
    private ArrayList<String> odpovedi = new ArrayList<>();
    private int spravnaOdpoved;

    //konstructory
    public Otazka() {
    }

    public Otazka(String otazka, ArrayList<String> odpovedi, int spravnaOdpoved) {
        this.otazka = otazka;
        this.odpovedi = odpovedi;
        this.spravnaOdpoved = spravnaOdpoved;
    }

    //metody
    
    /**
     * Zjisti, zda je uzivatelova odpoved spravna
     * @param answer odpoved nactena od uzivatele
     * @return true pokud je odpověd správná
     */
    public boolean isCorrect(int answer) {
        return (answer == spravnaOdpoved);
    }
    
    //gettery
    public String getOtazka() {
        return otazka;
    }

    public List<String> getOdpovedi() {
        return odpovedi;
    }

    public int getSpravnaOdpoved() {
        return spravnaOdpoved;
    }

    //settery
    public void setOtazka(String Otazka) {
        this.otazka = Otazka;
    }

    void setOdpovedi(ArrayList<String> Odpovedi) {
        this.odpovedi = Odpovedi;
    }

    public void setSpravnaOdpoved(int spravnaOdpoved) {
        if (spravnaOdpoved < this.getOdpovedi().size() && spravnaOdpoved > 0){
            this.spravnaOdpoved = spravnaOdpoved;
        }
        else this.spravnaOdpoved = -1;
    }

    @Override
    public String toString() {
        return otazka + "\n" + String.join("\n", odpovedi);
    }

}
