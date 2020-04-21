package pomeisl_bank;

/**
 *
 * @author Pomeisl Petr
 */
public class Person extends Client{
    
    //Data
        private String name;
        
    //Constructors
        public Person(String name){
            super(name);
            this.name = name;
        }
    
    @Override
    public String nameToString() {
        String last3 = name.substring(name.length() - 3); //gets last 3 letters from name
        if("ova".equals(last3)){
            return "paní " + name;
        }else{
            return "pan " + name;
        }
    }
    
}
