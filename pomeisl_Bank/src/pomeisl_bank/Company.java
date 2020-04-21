package pomeisl_bank;

/**
 *
 * @author Pomeisl Petr
 */
public class Company extends Client{

    //Data
        private String name;
    
    //Constructors
        public Company(String name){
            super(name);
            this.name = name;
        }
    
    @Override
    public String nameToString() {
        return "firma " + name;
    }
}
