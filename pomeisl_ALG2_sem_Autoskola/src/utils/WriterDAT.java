/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import app.Otazka;
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
                dos.writeUTF(test.getName());
                dos.writeInt(test.getCorrectAnswers());
                dos.writeLong(test.getDuration().toNanoOfDay());
        }
    }
    
}
