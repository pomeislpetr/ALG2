package utils;

import app.Test;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Pomeisl Petr
 */
public class WriterTXT extends Writer {

    /**
     * Uloží data do textového souboru.
     * @param resultFilepath Název výstupního souboru
     * @param room Sada uložených testů
     * @throws IOException 
     */
    @Override
    public void saveResults(String resultFilepath, ArrayList<Test> room) throws IOException {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(resultFilepath, false)))) {
            for (Test test : room) {
                pw.println(test.toString());
            }
        }
    }

}
