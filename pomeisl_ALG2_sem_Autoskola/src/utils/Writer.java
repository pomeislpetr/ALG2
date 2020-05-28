package utils;

import app.Test;
import java.io.IOException;

/**
 *
 * @author Pomeisl Petr
 */
public abstract class Writer {

    public abstract void saveResults(String resultFilepath, Test test) throws IOException;

}
