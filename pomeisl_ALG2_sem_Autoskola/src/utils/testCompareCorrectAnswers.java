package utils;

import app.Test;
import java.util.Comparator;

/**
 *
 * @author Pomeisl Petr
 */
public class testCompareCorrectAnswers implements Comparator<Test>{

    /**
     * Porovná počet správných odpovědí dvou testů
     * @param o1 test pro porovnání
     * @param o2 test pro porovnání
     * @return Integer reprezentující větší, menší, stejné
     */
    @Override
    public int compare(Test o1, Test o2) {
        return o1.getCorrectAnswers() - o2.getCorrectAnswers();
    }
    
}
