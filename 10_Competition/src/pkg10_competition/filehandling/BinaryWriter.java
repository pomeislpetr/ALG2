package pkg10_competition.filehandling;

import pkg10_competition.filehandling.Writer;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import pkg10_competition.app.Runner;

/**
 *
 * @author Pomeisl Petr
 */
public class BinaryWriter extends Writer {

    @Override
    public void saveResults(String resultFilepath, List<Runner> runners) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(resultFilepath))) {
            dos.writeUTF("Nové výsledky");
            int n = 1;
            for (Runner runner : runners) {
                dos.writeInt(n);
                //dos.writeChar('.');
                dos.writeUTF(runner.getFirstname());
                int nChars = runner.getLastname().length();
                dos.writeInt(nChars);
                for (int i = 0; i < nChars; i++) {
                    dos.writeChar(runner.getLastname().charAt(i));
                }
                dos.writeLong(runner.runningTime().toNanoOfDay());
                n++;
            }
        }
    }

}
