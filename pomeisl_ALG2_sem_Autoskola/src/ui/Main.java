package ui;

import app.Otazka;
import app.Test;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Pomeisl Petr
 */
public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        
        int choice;
        boolean run = true;
        while(run){
            printMenu();
            switch(choice = sc.nextInt()){
                case(1) :
                    Test test = new Test();
                    while(true){
                        try {
                            test.load(".\\src\\data\\Otazky.txt");
                            break;
                        } catch (IOException ex) {
                            System.out.println("Chyba pri nacitani souboru");
                        }
                    }
                    for (Otazka Otazka : test.getTest()) {
                        System.out.println(Otazka.toString());
                        System.out.print("Odpoved: ");
                        choice = sc.nextInt();
                        if (test.isCorrect(choice, Otazka)) {
                            System.out.println("Spravna odpoved!");
                        }else{
                            System.out.println("Spatne! Spravna odpoved byla " + Otazka.getSpravnaOdpoved());
                        }
                        System.out.println("");
                    }
                    System.out.println("");
                    System.out.println("Konec testu. Stisknete enter pro pokracovani");
                    test.pressEnterKeyToContinue();
                    break;
                case(2) :
                        
                    break;
                case(3) :
                    break;
                case(0) :
                    run = false;
                    break;
            }
        }
    }
    
    
    private static void printMenu(){
        System.out.format("%nMain menu%n");
        System.out.println("(1) Spustit test");
        System.out.println("(2) Porovnat výsledky");
        System.out.println("(3) Uložit výsledky do souboru");
        System.out.format("%n(0) Zavřít%n");
        System.out.format("%nVýběr: ");
    }
}
