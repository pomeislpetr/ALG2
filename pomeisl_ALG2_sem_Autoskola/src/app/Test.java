package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import static ui.Main.isInt;
import static ui.Main.sc;
import utils.Writer;
import utils.WriterDAT;
import utils.WriterTXT;

/**
 * Třída reprezentující jednotlivé testy.
 * @author Pomeisl Petr
 */
public class Test implements Comparable<Test>, TestInterface{

    private ArrayList<Otazka> test = new ArrayList<>();
    private String firstName;
    private String lastName;
    private int CorrectAnswers = 0;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalTime duration;
    public static DateTimeFormatter durationFormat
            = DateTimeFormatter.ofPattern("HH:mm:ss");

    public Test(String firstName, String lastName, String duration, int CorrectAnswers) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.duration = LocalTime.parse(duration, durationFormat);
        this.CorrectAnswers = CorrectAnswers;
    }

    public Test() {
    }

    
    //metody
    /**
     * Nacte vstupni soubor do programu.
     * @param filePath cesta ke vstupnimu souboru
     * @throws FileNotFoundException
     * @throws IOException 
     */
    @Override
    public void load(String filePath) throws FileNotFoundException, IOException {
        File Otazky = new File(filePath);
        try (BufferedReader load = new BufferedReader(new FileReader(Otazky))) {
            String line;
            while ((line = load.readLine()) != null) {
                Otazka o = new Otazka();
                String[] parts = line.split("[-]");
                o.setOtazka(parts[0]);
                ArrayList<String> odpovedi = new ArrayList<>();
                for (int i = 1; i < parts.length; i++) {
                    if (parts[i].equals("*")) {
                        o.setSpravnaOdpoved(i - 1);
                    } else {
                        odpovedi.add(parts[i]);
                    }
                }
                o.setOdpovedi(odpovedi);
                test.add(o);
            }
        }
        System.out.println("Soubor nacten!");
    }
    
    /**
     * Prochazi test otazku po otazce a zapisuje odpovedi
     */
    @Override
    public void runTest(){
        int choice;
        for (Otazka otazka : test) {
            if (otazka.getSpravnaOdpoved() != -1){
                System.out.println(otazka.toString());
                System.out.print("Odpoved: ");
                while (true){
                    choice = isInt(sc);
                    if (choice > 3 || choice < 1){
                        System.out.print("Neplatna odpoved! Zadejte znovu: ");
                    } else {
                        break;
                    }
                }

                if (otazka.isCorrect(choice)) {
                    System.out.println("Spravna odpoved!");
                    CorrectAnswers++;
                }else{
                    System.out.println("Spatne! Spravna odpoved byla " + otazka.getSpravnaOdpoved());
                }
                System.out.println("");
            }
        }
    }
    
    /**
     * vypocita cas, za jaky uzivatel splnil test
     */
    @Override
    public void duration() {
        this.duration = LocalTime.ofSecondOfDay((this.endTime.toSecondOfDay()
                - this.startTime.toSecondOfDay()));
    }
    
    /**
     * Ulozi vysledek testu do vystupniho souboru
     * @param resultFilepath cesta k vystupnimu souboru
     * @throws IOException
     * @throws IllegalArgumentException 
     */
    @Override
    public void saveResults(String resultFilepath, ArrayList<Test> room) throws IOException, IllegalArgumentException{
        Writer wr = null;
        if (resultFilepath.endsWith(".txt")) {
            wr = new WriterTXT();
        } else if (resultFilepath.endsWith(".dat")) {
            wr = new WriterDAT();
        } else {
            throw new IllegalArgumentException("Nepodporovaný typ souboru!");
        }
        wr.saveResults(resultFilepath, room);
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

    /**
     * Porovná Duration objektů typu Test
     * @param o Test, se kterým tento porovnávám.
     * @return Integer reprezentující větší, menší, stejné
     */
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
