package app;

import java.util.ArrayList;
import pomeisl_bank.Client;
import pomeisl_bank.Company;
import pomeisl_bank.Person;

/**
 *
 * @author Pomeisl Petr
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Client> myBank = new ArrayList<>();
        myBank.add(new Person("Pekar"));
        myBank.add(new Person("Svecova"));
        myBank.add(new Company("Skoda"));
        
        (myBank.get(0)).createAccount(1000);
        (myBank.get(0)).createAccount(500);
        //System.out.println((myBank.get(0)).toString()); //test
        //System.out.println((myBank.get(0)).nameToString()); //test
        (myBank.get(1)).createAccount(1200);
        (myBank.get(2)).createAccount(120);
        
        System.out.println((myBank.get(0)).nameToString() + " má na účtech celkem: " + (myBank.get(0)).allAcountsBalance() + ",- Kč");
        System.out.println((myBank.get(1)).nameToString() + " má na účtech celkem: " + (myBank.get(1)).allAcountsBalance() + ",- Kč");
        System.out.println((myBank.get(2)).nameToString() + " má na účtech celkem: " + (myBank.get(2)).allAcountsBalance() + ",- Kč");
    }
}
