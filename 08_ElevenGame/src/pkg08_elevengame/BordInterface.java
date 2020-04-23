package pkg08_elevengame;

/**
 *
 * @author Pomeisl Petr
 */
public interface BordInterface {

    /**
     *
     * @return
     */
    public String getName();
    
    /**
     *
     * @return
     */
    public int nCards();
    
    /**
     *
     * @return
     */
    public int getDeckSize();
    
    /**
     *
     * @param index
     * @return
     */
    public String getCardDescriptionAt(int index);

    /**
     *
     * @return
     */
    public boolean isAnotherPlayPosible();

    /**
     *
     * @param selectedCardsPositions
     * @return
     */
    public boolean playAndReplace(String[] selectedCardsPositions);

    /**
     *
     * @return
     */
    public boolean hasWon();
    
}
