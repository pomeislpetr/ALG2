package app;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Pomeisl Petr
 */
public interface TestInterface {
    
    /**
     * Nacte vstupni soubor do programu.
     * @param filePath cesta ke vstupnimu souboru
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void load(String filePath) throws FileNotFoundException, IOException;
    
    /**
     * Prochazi test otazku po otazce a zapisuje odpovedi
     */
    public void runTest();
    
    /**
     * vypocita cas, za jaky uzivatel splnil test
     */
    public void duration();
    
    /**
     * Ulozi vysledek testu do vystupniho souboru
     * @param resultFilepath cesta k vystupnimu souboru
     * @param room vsechny vysledky od spusteni programu
     * @throws IOException
     * @throws IllegalArgumentException 
     */
    public void saveResults(String resultFilepath, ArrayList<Test> room) throws IOException, IllegalArgumentException;
}
