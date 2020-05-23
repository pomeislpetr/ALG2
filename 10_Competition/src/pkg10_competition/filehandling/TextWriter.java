package pkg10_competition.filehandling;

import pkg10_competition.filehandling.Writer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import pkg10_competition.app.Runner;

/**
 *
 * @author Pomeisl Petr
 */
public class TextWriter extends Writer {

    @Override
    public void saveResults(String resultFilepath, List<Runner> runners) throws IOException {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(resultFilepath, true)))) {
            //PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out, "Cp1250"), true);
            pw.println("Nové výsledky");
            int n = 1;
            for (Runner runner : runners) {
                pw.print(n + ". ");
                pw.println(runner);
                n++;
            }
        }
    }

}
