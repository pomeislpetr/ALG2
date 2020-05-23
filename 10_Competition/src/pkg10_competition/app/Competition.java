package pkg10_competition.app;

import pkg10_competition.utils.IllegalFilenameException;
import pkg10_competition.filehandling.BinaryWriter;
import pkg10_competition.filehandling.TextWriter;
import pkg10_competition.filehandling.Writer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author Pomeisl Petr
 */
public class Competition {

    private ArrayList<Runner> runners = new ArrayList<>();

    public void load(String startFilepath, String finishFilepath) throws FileNotFoundException, IOException {
//        //start2019, Start2019, start19 2000-2030
//        if (!startFilepath.matches("^[Ss]tart(20)?([0-2][0-9]|30)")) {
//            throw new IllegalArgumentException("nepodporovany nazev souboru");
//        }
//
//        //vlastni vyjimka
//        if (!startFilepath.contains("start")) {
//            throw new IllegalFilenameException("Start soubor musí obsahovat start!");
//        }

        //nacitani pomoci Scanner
        File startFile = new File(startFilepath);
        try (Scanner inStart = new Scanner(startFile)) {
            while (inStart.hasNext()) {
                int number = inStart.nextInt();
                String firstname = inStart.next();
                String lastname = inStart.next();
                String startTime = inStart.next();
                Runner r = new Runner(number, firstname, lastname);
                r.setStartTime(startTime);
                runners.add(r);
            }
        }

        //nacitani pomoci BufferedReader
        File finishFile = new File(finishFilepath);
        try (BufferedReader inFinish = new BufferedReader(new FileReader(finishFile))) {
            String line;
            while ((line = inFinish.readLine()) != null) { //102 10:02:00:000
                String[] parts = line.split("[ ]+");
                try {
                    Runner r = findRunner(Integer.parseInt(parts[0]));
                    r.setFinishTime(parts[1]);
                } catch (NoSuchElementException e) {
                    System.err.print(e.getMessage());
                }
            }
        }
    }

    public String getResults() {
        Collections.sort(runners);
        StringBuilder sb = new StringBuilder("");
        int n = 1;
        for (Runner runner : runners) {
            sb.append(String.format("%-2d. %s%n", n, runner));
            n++;
        }
        return sb.toString();
    }

    public void saveResults(String resultFilepath) throws IOException {
        Collections.sort(runners);
        Writer w = null;
        if (resultFilepath.endsWith(".txt")) {
            w = new TextWriter();
            System.out.println("text");
        } else if (resultFilepath.endsWith(".dat")) {
            w = new BinaryWriter();
        } else {
            throw new IllegalArgumentException("Nepodporovaný typ souboru!");
        }
        w.saveResults(resultFilepath, runners);
    }

    private Runner findRunner(int number) {
        for (Runner runner : runners) {
            if (runner.getNumber() == number) {
                return runner;
            }
        }
        throw new NoSuchElementException("Běžec s číslem " + number + " nebyl na startu!");
    }

}
