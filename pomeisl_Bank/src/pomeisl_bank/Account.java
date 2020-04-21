package pomeisl_bank;

/**
 *
 * @author Pomeisl Petr
 */
public class Account{
    //Data
        private double balance = 0;

    //Constructors
    
        /**
         * Creates new empty account. | Vytváří nový prázdný účet.
         */
        public Account() {
            this.balance = 0;
        }
        
        /**
         * Creates new account with initial deposit. | Vytváří nový účet s počátečním vkladem.
         * @param deposit Initial deposit to the account.
         */
        public Account(double deposit) {
            this.balance = deposit;
        }
        
    //Getters

        /**
         * Getter for balance.
         * @return Balance of the account.
         */
        public double getBalance() {
            return balance;
        }
        
    //ToString
        /**
         * ToString override.
         * @return "Account balance: xx,- Kč"
         */
        @Override
        public String toString() {
            return "Account balance: " + balance + ",- Kč";
        }
        
    //Methods

        /**
         * Makes a deposit to the account. | Provede vklad na účet.
         * @param deposit Amount of money to deposit to the account.
         */
        public void deposit(double deposit){
            this.balance = this.balance + deposit;
        }
    
        /**
         * Makes a withdrawal from the account. | Provede výběr z účtu.
         * @param withdrawal Amount of money to withdrawal from the account.
         */
        public void withdrawal(double withdrawal){
            this.balance = this.balance - withdrawal;
        }
    
}
