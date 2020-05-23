package pkg10_competition.ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import pkg10_competition.app.Competition;

/**
 *
 * @author Pomeisl Petr
 */
public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Competition c = new Competition();
        System.out.println("Zadej nazvy vstupnich souboru:");
        try {
            while (true) {
                try {
                    String startFile = sc.next();
                    String finishFile = sc.next();
                    c.load(startFile, finishFile);
                    break;
                } catch (FileNotFoundException e) {
                    System.out.println("Zadán neplatný soubor! Zadej znovu:");
                }
            }
            System.out.println(c.getResults());
            System.out.println("Zadej nazev vystupniho souboru");
            String resultFile = sc.next();
            c.saveResults(resultFile);
            System.out.println("Data byla uložena.");
        } catch (IOException e) {
            System.out.println("Chyba při čtení a zápisu!");
        }
    }
}
