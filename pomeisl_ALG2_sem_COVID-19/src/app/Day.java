package app;

/**
 *
 * @author Pomeisl Petr
 */
class Day implements Comparable<Day>{

    private int dateDay;
    private int dateMonth;
    private int dateYear;
    private int infected;
    private int cured;
    private int deaths;
    
    @Override
    public int compareTo(Day o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Day() {
    }
    
    public Day(int dateDay, int dateMonth, int dateYear, int infected, int cured, int deaths) {
        this.dateDay = dateDay;
        this.dateMonth = dateMonth;
        this.dateYear = dateYear;
        this.infected = infected;
        this.cured = cured;
        this.deaths = deaths;
    }

    public int getDateDay() {
        return dateDay;
    }

    public int getDateMonth() {
        return dateMonth;
    }

    public int getDateYear() {
        return dateYear;
    }

    public int getInfected() {
        return infected;
    }

    public int getCured() {
        return cured;
    }

    public int getDeaths() {
        return deaths;
    }

    @Override
    public String toString() {
        return String.format("%-2d.%-2d.%-4d %-5d%-3d%-4d", dateDay, dateMonth, dateYear, infected, cured, deaths);
    }
    
}
