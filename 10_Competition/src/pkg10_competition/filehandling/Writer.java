package pkg10_competition.filehandling;

import java.io.IOException;
import java.util.List;
import pkg10_competition.app.Runner;

/**
 *
 * @author Pomeisl Petr
 */
public abstract class Writer {

    public abstract void saveResults(String resultFilepath, List<Runner> runners) throws IOException;
}
