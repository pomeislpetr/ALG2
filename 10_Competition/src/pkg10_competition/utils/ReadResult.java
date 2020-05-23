package pkg10_competition.utils;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalTime;
import pkg10_competition.app.Runner;

/**
 *
 * @author Pomeisl Petr
 */
public class ReadResult {

    public static void main(String[] args) {
        try {
            readResult("result.dat");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void readResult(String resultFilepath) throws FileNotFoundException, IOException {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(resultFilepath))) {
            boolean isEnd = false;
            System.out.println(dis.readUTF());
            while (!isEnd) {
                try {
                    System.out.print(dis.readInt() + ". ");
                    String firstName = dis.readUTF();
                    int nChars = dis.readInt();
                    String lastName = "";
                    for (int i = 0; i < nChars; i++) {
                        lastName += dis.readChar();
                    }
                    LocalTime runningTime = LocalTime.ofNanoOfDay(dis.readLong());
                    System.out.println(firstName + " " + lastName + " " + runningTime.format(Runner.dtffinish));
                } catch (EOFException e) {
                    isEnd = true;
                }
            }
        }
    }
}
