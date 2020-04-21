package pomeisl_bank;

import java.util.ArrayList;

/**
 *
 * @author Pomeisl Petr
 */
public abstract class Client {
    
    //Data
        protected String name;
        protected ArrayList<Account> accounts = new ArrayList<>();

    //Constructors
        public Client(String name) {
            this.name = name;
        }

    //Getters
        public String getName() {
            return name;
        }

        /**
         *
         * @return
         */
        public ArrayList<Account> getAccounts() {
            return accounts;
        }
    
    //ToString
        /**
         * 
         * @return 
         */
        @Override
        public String toString() {
            return "Client{" + "name = " + name + ", accounts = " + accounts + '}';
        }
    
    //Methods
        public abstract String nameToString();
        
        public void createAccount(double deposit){
            accounts.add(new Account(deposit));
        }
    
        public double allAcountsBalance(){
            double allAccountsBalance = 0;
            for (Account account : accounts) {
                allAccountsBalance = allAccountsBalance + account.getBalance();
            }
            return allAccountsBalance;
        }
        
    //Testing
//        public static void main (String[] args){
//            Client test = new Client("test");
//            test.createAccount(50);
//            System.out.println(test.toString());
//        }
}
