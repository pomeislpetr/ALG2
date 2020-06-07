package utils;

import app.Test;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Pomeisl Petr
 */
public abstract class Writer {

    /**
     * Uloží data do binárního nebo textového souboru.
     * @param resultFilepath Název výstupního souboru
     * @param room Sada uložených testů
     * @throws IOException 
     */
    public abstract void saveResults(String resultFilepath, ArrayList<Test> room) throws IOException;

}
