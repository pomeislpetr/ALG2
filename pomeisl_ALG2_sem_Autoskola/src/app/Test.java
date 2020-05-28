package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Pomeisl Petr
 */
public class Test {
    private ArrayList<Otazka> test = new ArrayList<>();
    private String name;
    private int CorrectAnswers = 0;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalTime duration;
    public static DateTimeFormatter durationFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
    
    public void load(String filePath) throws FileNotFoundException, IOException{
        File Otazky = new File(filePath);
        try (BufferedReader load = new BufferedReader(new FileReader(Otazky))){
            String line;
            while ((line = load.readLine()) != null){
                Otazka o = new Otazka();
                String[] parts = line.split("[-]");
                o.setOtazka(parts[0]);
                ArrayList<String> Odpovedi = new ArrayList<>();
                for (int i = 1; i < parts.length; i++) {
                    if (parts[i].equals("*")){
                        o.setSpravnaOdpoved(i-1);
                    }else{
                        Odpovedi.add(parts[i]);
                    }
                }
                o.setOdpovedi(Odpovedi);
                test.add(o);
            }
        }
    }

    public void setStartTime() {
        this.startTime = LocalTime.now();
    }

    public void setEndTime() {
        this.endTime = LocalTime.now();
    }

    public void duration(LocalTime startTime, LocalTime endTime){
        this.duration = LocalTime.parse((endTime.toSecondOfDay() - startTime.toSecondOfDay()), durationFormat);
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public void setCorrectAnswers(int CorrectAnswers) {
        this.CorrectAnswers = CorrectAnswers;
    }
    
    public ArrayList<Otazka> getTest() {
        return test;
    }

    public int getCorrectAnswers() {
        return CorrectAnswers;
    }
    
    public boolean isCorrect(int answer, Otazka o){
        this.CorrectAnswers ++;
        return answer == o.getSpravnaOdpoved();
    }
    
    public void pressEnterKeyToContinue() { 
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
}

    public LocalTime getDuration() {
        return duration;
    }
    
    public static void main(String[] args) throws IOException {
        Test test = new Test();
        test.load(".\\src\\data\\Otazky.txt");
    }
}
