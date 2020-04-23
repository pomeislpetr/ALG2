package pkg08_elevengame;

/**
 *
 * @author Pomeisl Petr
 */
public class Bord implements BordInterface{
    Card[] cards; //9 cards on the board
    Deck deck; //Shufled deck of cards

    @Override
    public String getName() {
        return "Eleven the game";
    }

    @Override
    public int nCards() {
        return cards.length;
    }

    @Override
    public int getDeckSize() {
        return 43;
    }

    @Override
    public String getCardDescriptionAt(int index){
        return cards[index].getRank()+cards[index].getSuit();
    }

    @Override
    public boolean isAnotherPlayPosible() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean playAndReplace(String[] selectedCardsPositions) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean hasWon() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
