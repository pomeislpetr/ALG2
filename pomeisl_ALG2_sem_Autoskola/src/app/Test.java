package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Pomeisl Petr
 */
public class Test {
    private ArrayList<Otazka> test = new ArrayList<>();
    private int CorrectAnswers = 0;
    
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
    
    public static void main(String[] args) throws IOException {
        Test test = new Test();
        test.load(".\\src\\data\\Otazky.txt");
    }
}
