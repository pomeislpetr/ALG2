package utils;

import app.Test;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Pomeisl Petr
 */
public class WriterTXT extends Writer {

    @Override
    public void saveResults(String resultFilepath, Test test) throws IOException {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(resultFilepath, true)))) {
            pw.println(test.toString());
        }
    }

}
