package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author Pomeisl Petr
 */
public class Pandemic {
    private ArrayList<Day> pandemic = new ArrayList<>();
    
    /**
     * Loads data from input file, creats new object "Day" and adds it to pandemic ArrayList.
     * @param InputFilepath Filepath to input file.
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void load(String InputFilepath) throws FileNotFoundException, IOException{
        File InputFile = new File(InputFilepath);
        try(BufferedReader loadInput = new BufferedReader(new FileReader(InputFile))){
            String line;
            while((line = loadInput.readLine()) != null){
                String[] parts = line.split("[ ]+");
                Day d = new Day(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]),
                        Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), Integer.parseInt(parts[5]));
                pandemic.add(d);
            }
        }
    }

    
    public void show() {
        for (Day day : pandemic) {
            System.out.println(day.toString());
        }
    }

    
    
}
