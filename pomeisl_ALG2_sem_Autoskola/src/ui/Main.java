package ui;

import app.Otazka;
import app.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Pomeisl Petr
 */
public class Main {
    public static Scanner sc = new Scanner(System.in);
    ArrayList<Test> students = new ArrayList<>();
    
    public static void main(String[] args) {
        
        int choice;
        boolean run = true;
        while(run){
            printMenu();
            switch(choice = sc.nextInt()){
                case(1) :
                    Test test = new Test();
                    System.out.print("Napis sve jmeno: ");
                    test.setName(sc.nextLine());
                    System.out.println("");
                    test.setStartTime();
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
                        while (true){
                            choice = sc.nextInt();
                            if (choice > 3 || choice < 1){
                                System.out.print("Neplatna odpoved. Zadejte znovu: ");
                            } else {
                                break;
                            }
                        }
                        if (test.isCorrect(choice, Otazka)) {
                            System.out.println("Spravna odpoved!");
                        }else{
                            System.out.println("Spatne! Spravna odpoved byla " + Otazka.getSpravnaOdpoved());
                        }
                        System.out.println("");
                    }
                    test.setEndTime();
                    test.duration(test.getStartTime(), test.getEndTime());
                    System.out.println("");
                    
                    System.out.println("Konec testu.");
                    System.out.println("Vase skore je " + test.getCorrectAnswers() + " spravnych odpovedi.");
                    System.out.println("Test byl splnen za " + test.getDuration());
                    System.out.println("");
                    
                    System.out.println("Prejete si ulozit vysledky?");
                    System.out.format("(1) ANO%n(2)NE%nVyber: ");
                    switch (sc.nextInt()){
                        case(1) :
                            System.out.print("Zadejte nazev koncoveho souboru: ");
                            while(true){
                                try{
                                    try{
                                        String resultFilepath = ".\\src\\data\\" + sc.next();
                                        test.saveResults(resultFilepath);
                                        System.out.format("%nData byla ulozena!%n");
                                        break;
                                    } catch (IOException ex) {
                                        System.out.println("Chyba pri ukladani souboru!");
                                    }
                                } catch (IllegalArgumentException e){
                                    System.out.print("Nepodporovany typ souboru! Zadejte znovu: ");
                                }
                            }
                            break;
                        case(2) :
                            break;
                    }
                    
                    System.out.println("stisknete enter pro navrat do menu");
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
    
    /**
     * Vytiskne hlavni menu na konzoli.
     */
    private static void printMenu(){
        System.out.format("%nMain menu%n");
        System.out.println("(1) Spustit test");
        System.out.println("(2) Porovnat výsledky");
        System.out.println("(3) Odeslat emailem");
        System.out.format("%n(0) Zavřít%n");
        System.out.format("%nVýběr: ");
    }
}
