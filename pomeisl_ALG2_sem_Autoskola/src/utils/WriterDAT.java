package utils;

import app.Test;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Pomeisl Petr
 */
public class WriterDAT extends Writer{

    /**
     * Uloží data do binárního souboru.
     * @param resultFilepath Název výstupního souboru
     * @param room Sada uložených testů
     * @throws IOException 
     */
    @Override
    public void saveResults(String resultFilepath, ArrayList<Test> room) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(resultFilepath))) {
            for (Test test : room) {
                dos.writeUTF(test.getFirstName());
                dos.writeUTF(test.getLastName());
                dos.writeInt(test.getCorrectAnswers());
                dos.writeLong(test.getDuration().toNanoOfDay());
            }
        }
    }
    
}
