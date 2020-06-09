package ui;

import app.Otazka;
import app.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import utils.Email;
import utils.testCompareCorrectAnswers;

/**
 * Hlavní třída programu
 * @author Pomeisl Petr
 */
public class Main {
    public static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        ArrayList<Test> room = new ArrayList<>();
        example(room);        
        
        int choice;
        boolean run = true;
        while(run){
            printMenu();
            switch(choice = isInt(sc)){
                case(1) :
                    Test test = new Test();
                    
                    System.out.print("Zadejte jméno a přijmení: ");
                    test.setFirstName(sc.next());
                    test.setLastName(sc.next());
                    
                    while(true){
                        try {
                            test.load(".\\src\\data\\Otazky.txt");
                            break;
                        } catch (IOException ex) {
                            System.out.println("Chyba pri nacitani souboru");
                        }
                    }
                    
                    System.out.format("%nStisknete enter pro zahajeni testu%n");
                    pressEnterKeyToContinue();
                    
                    test.setStartTime();
                    
                    //vyplneni testu
                    test.runTest();
                    
                    test.setEndTime();
                    
                    test.duration();
                    System.out.println("");
                    
                    room.add(test);
                    
                    System.out.println("Konec testu.");
                    System.out.println("Vase skore je " + test.getCorrectAnswers() + " spravnych odpovedi.");
                    System.out.println("Test byl splnen za " + test.getDuration());
                    System.out.println("");
                    
                    System.out.println("stisknete enter pro navrat do menu");
                    pressEnterKeyToContinue();
                    break;
                case(2) :
                    printSortingMenu();
                    switch (sc.nextInt()){
                        case (1) :
                            Collections.sort(room, new testCompareCorrectAnswers());
                            break;
                        case (2) :
                            Collections.sort(room);
                            break;
                        case (0) :
                            break;
                    }
                    
                    room.forEach((tests) -> {
                        System.out.println(tests.toString());
                    });
                    
                    System.out.println("Prejete si ulozit vysledky?");
                    System.out.format("(1) ANO%n(2)NE%nVyber: ");
                    switch (isInt(sc)){
                        case(1) :
                            System.out.print("Zadejte nazev koncoveho souboru: ");
                            while(true){
                                try{
                                    try{
                                        String resultFilepath = ".\\src\\data\\" + sc.next();
                                        for (Test test1 : room) {
                                        test1.saveResults(resultFilepath, room);
                                        }
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
                    break;
                case(3) :
                        printEmailMenu();
                        Email email = new Email();
                        try {
                            switch(isInt(sc)){
                                case(1) :
                                    email.sendResults();
                                    break;
                                case(2) :
                                    System.out.print("Zadejte adresu prijemce (napr. prijemce@email.com): ");
                                    while (true){
                                        email.setTo(sc.next());
                                        if (email.getTo().matches("^(.+)@(.+)$")){
                                            System.out.print("Zadejte nazev souboru s vysledky: ");
                                            email.setFilename(sc.next());
                                            System.out.println("");
                                            email.sendResults();
                                            break;
                                        }
                                        System.out.print("Neplatna adresa. Zadejte znovu: ");
                                    }
                                    break;
                                case(0) :
                                    break;
                            }
                        } catch (AddressException e){
                            System.out.println("Nastala chyba pri odesilani!");
                        } catch (MessagingException e) {
                            System.out.println("Nastala chyba pri odesilani!");
                        } catch (NullPointerException e){
                            System.out.println("Neplatny nazev souboru!");
                        }
                    break;
                case(0) :
                    printQuitMenu();
                    switch(isInt(sc)){
                        case 1 :
                            run = false;
                            break;
                        case 0 :
                            break;
                    }
            }
        }
    }
    
    /**
     * Vytiskne hlavni menu na konzoli.
     */
    private static void printMenu(){
        System.out.format("%nMain menu%n");
        System.out.println("(1) Spustit test");
        System.out.println("(2) Setřídit a uložit výsledky");
        System.out.println("(3) Odeslat emailem");
        System.out.format("%n(0) Zavřít%n");
        System.out.format("%nVýběr: ");
    }
    
    /**
     * Vytiskne menu pro odesilani emailu na konzoli.
     */
    private static void printEmailMenu(){
        System.out.format("%nSending email%n");
        System.out.println("(1) Odestal defaultni email");
        System.out.println("(2) Odeslat vlastni email");
        System.out.println("(0) Zrusit");
        System.out.format("%nVýběr: ");
    }
    
    /**
     * Vytiskne menu pro třídění a ukládání na konzoli.
     */
    private static void printSortingMenu(){
        System.out.format("%nSorting results%n");
        System.out.println("(1) Srovnat podle počtu správných odpovědí");
        System.out.println("(2) Srovnat podle času testu");
        System.out.println("(0) Zrusit");
        System.out.format("%nVýběr: ");
    }
    
    /**
     * Vytiskne menu pro ukončení programu na konzoli.
     */
    private static void printQuitMenu(){
        System.out.format("%nJste si jistí? Všechna neuložená data budou ztracena!%n");
        System.out.println("(1) Ano");
        System.out.println("(0) Ne");
        System.out.format("%nVýběr: ");
    }
    
    /**
     * Čeká na odezvu od uživatele.
     */
    public static void pressEnterKeyToContinue() {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
      
    /**
     * Kontroluje, že je vstup typu Integer
     * @param sc Scanner načítající od uživatele
     * @return Vstup typu Integer
     */
    public static int isInt(Scanner sc){
        int choice;
        while(!sc.hasNextInt()){
            System.out.print("Neplatna odpoved! Zadejte znovu: ");
            sc.next();
        }
        choice = sc.nextInt();
        return choice;
    }
    
    private static void example(ArrayList<Test> room){
        Test a = new Test("David", "Testovany", "00:00:10", 6);
        room.add(a);
        Test b = new Test("Alice", "Nejedla", "00:00:14", 2);
        room.add(b);
        Test c = new Test("Veronika", "Zdrava", "00:00:11", 0);
        room.add(c);
    }
    
}
