package utils;

import app.Test;
import java.util.Comparator;

/**
 *
 * @author Pomeisl Petr
 */
public class testCompareCorrectAnswers implements Comparator<Test>{

    @Override
    public int compare(Test o1, Test o2) {
        return o1.getCorrectAnswers() - o2.getCorrectAnswers();
    }
    
}
