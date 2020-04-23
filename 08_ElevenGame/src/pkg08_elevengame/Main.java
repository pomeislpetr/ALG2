package pkg08_elevengame;

import java.util.Scanner;

/**
 *
 * @author Pomeisl Petr
 */
public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static BordInterface bord;

    public static void main(String[] args) {
        System.out.println("******************* " + bord.getName() + " *******************");
        
        displayCards();
        displayDeck();

        while(bord.isAnotherPlayPosible()){ //jsou karty v balicku nebo na stole A existuje JQK nebo suma 11
            System.out.println("Choose cards:");
            String[] selectedCardsPositions = sc.nextLine().split(" +");
            if (!bord.playAndReplace(selectedCardsPositions)) {
                System.out.println("Invalid move!");
            } else {
                displayCards();
                displayDeck();
            }
        }
        if(bord.hasWon()){
            System.out.println("Congratulations!");
        }else {
            System.out.println("Game over!");
        }
    }

    private static void displayCards() {
        for (int i = 0; i < bord.nCards(); i++) {
            System.out.format("%1d. %10s        ", (i + 1), bord.getCardDescriptionAt(i));
            if ((i + 1) % 3 == 0) {
                System.out.println("");
            }
        }
    }

    private static void displayDeck() {
        System.out.println("In the deck remains " + bord.getDeckSize() + " card(s).");
    }

}
