package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import utils.Writer;
import utils.WriterDAT;
import utils.WriterTXT;

/**
 *
 * @author Pomeisl Petr
 */
public class Test implements Comparable<Test>{

    private ArrayList<Otazka> test = new ArrayList<>();
    private String firstName;
    private String lastName;
    private int CorrectAnswers = 0;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalTime duration;
    public static DateTimeFormatter durationFormat
            = DateTimeFormatter.ofPattern("HH:mm:ss");

    //metody
    /**
     * Nacte vstupni soubor do programu.
     * @param filePath cesta ke vstupnimu souboru
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void load(String filePath) throws FileNotFoundException, IOException {
        File Otazky = new File(filePath);
        try (BufferedReader load = new BufferedReader(new FileReader(Otazky))) {
            String line;
            while ((line = load.readLine()) != null) {
                Otazka o = new Otazka();
                String[] parts = line.split("[-]");
                o.setOtazka(parts[0]);
                ArrayList<String> Odpovedi = new ArrayList<>();
                for (int i = 1; i < parts.length; i++) {
                    if (parts[i].equals("*")) {
                        o.setSpravnaOdpoved(i - 1);
                    } else {
                        Odpovedi.add(parts[i]);
                    }
                }
                o.setOdpovedi(Odpovedi);
                test.add(o);
            }
        }
    }
    
    /**
     * Zjisti, zda je uzivatelova odpoved spravna
     * @param answer odpoved nactena od uzivatele
     * @param o otazka, na kterou uzivatel odpovida
     * @return 
     */
    public boolean isCorrect(int answer, Otazka o) {
        boolean isCorrect = (answer == o.getSpravnaOdpoved());
        if (isCorrect) {
            this.CorrectAnswers++;
        }
        return isCorrect;
    }
    
    /**
     * vypocita cas, za jaky uzivatel splnil test
     * @param startTime cas spusteni testu
     * @param endTime cas ukonceni testu
     */
    public void duration(LocalTime startTime, LocalTime endTime) {
        this.duration = LocalTime.ofSecondOfDay((endTime.toSecondOfDay()
                - startTime.toSecondOfDay()));
    }
    
    /**
     * Ulozi vysledek testu do vystupniho souboru
     * @param resultFilepath cesta k vystupnimu souboru
     * @throws IOException
     * @throws IllegalArgumentException 
     */
    public void saveResults(String resultFilepath) throws IOException, IllegalArgumentException{
        Writer wr = null;
        if (resultFilepath.endsWith(".txt")) {
            wr = new WriterTXT();
        } else if (resultFilepath.endsWith(".dat")) {
            wr = new WriterDAT();
        } else {
            throw new IllegalArgumentException("Nepodporovaný typ souboru!");
        }
        wr.saveResults(resultFilepath, this);
    }
    
    //gettery

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
   
    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }
    
    public LocalTime getDuration() {
        return duration;
    }

    public int getCorrectAnswers() {
        return CorrectAnswers;
    }
    
    public ArrayList<Otazka> getTest() {
        return test;
    }

    //settery
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void setStartTime() {
        this.startTime = LocalTime.now();
    }

    public void setEndTime() {
        this.endTime = LocalTime.now();
    }

    @Override
    public String toString() {
        return String.format("%-10s%-10s%-3d%-10s", this.getLastName(), this.getFirstName(),
                this.getCorrectAnswers(), this.getDuration());
    }

    @Override
    public int compareTo(Test o) {
        return this.getDuration().toSecondOfDay() - o.getDuration().toSecondOfDay();
    }
    
//    //test
//    public static void main(String[] args) throws IOException {
//        Test test = new Test();
//        test.load(".\\src\\data\\Otazky.txt");
//    }

    
}
