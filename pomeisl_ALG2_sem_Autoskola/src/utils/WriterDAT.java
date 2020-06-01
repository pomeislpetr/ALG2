package utils;

import app.Test;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Pomeisl Petr
 */
public class WriterDAT extends Writer{

    @Override
    public void saveResults(String resultFilepath, Test test) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(resultFilepath))) {
                dos.writeUTF(test.getFirstName());
                dos.writeUTF(test.getLastName());
                dos.writeInt(test.getCorrectAnswers());
                dos.writeLong(test.getDuration().toNanoOfDay());
        }
    }
    
}
