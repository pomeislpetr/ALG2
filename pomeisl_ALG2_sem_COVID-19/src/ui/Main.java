package ui;

import app.Pandemic;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Pomeisl Petr
 */
        
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Pandemic p = new Pandemic();
        
        int choice;
        boolean run = true;
        while(run){
            printMenu();
            switch(choice = sc.nextInt()){
                case(1) :
                    try {
                        System.out.print("%nChoose input file: ");
                        while(true){
                            try{
                                p.load(sc.next());
                                p.show();
                                break;
                            }catch (FileNotFoundException e){
                                System.out.format("%nNon-existing file!%n");
                            }
                        }
                    }catch (IOException e){
                        System.out.format("%nError while loading!%n");
                    }
                    break;
                case(2) :
                    break;
                case(3) :
                    break;
                case(4) :
                    break;
                case(5) :
                    break;
                case(0) :
                    run = false;
                    break;
            }
        }
    }
    
    /**
     * Prints main menu on user's terminal.
     */
    private static void printMenu(){
        System.out.format("%nMain menu%n");
        System.out.println("(1) Input filepath");
        System.out.println("(2) View data for a specific day");
        System.out.println("(3) Show total data");
        System.out.println("(4) Show graph");
        System.out.println("(5) Save to output file");
        System.out.format("%n(0) Close%n");
        System.out.format("%nYour choice: ");
    }
}
