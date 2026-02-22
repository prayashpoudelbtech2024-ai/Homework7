public class ATMSystem08 {

    // Custom Exceptions
    static class InsufficientFundsException extends Exception {
        InsufficientFundsException(String message) {
            super(message);
        }
    }

    static class InvalidAmountException extends Exception {
        InvalidAmountException(String message) {
            super(message);
        }
    }

    // BankAccount class
    static class BankAccount {
        int accountNumber;
        double balance;

        BankAccount(int accountNumber, double balance) {
            this.accountNumber = accountNumber;
            this.balance = balance;
        }

        void withdraw(double amount)
                throws InsufficientFundsException, InvalidAmountException {

            if (amount % 100 != 0) {
                throw new InvalidAmountException("Amount must be in multiples of 100");
            }

            if (amount > balance) {
                throw new InsufficientFundsException("Insufficient balance");
            }

            balance = balance - amount;
            System.out.println("Withdrawal successful");
            System.out.println("Remaining balance: " + balance);
        }
    }

    // Main method
    public static void main(String[] args) {
        BankAccount acc = new BankAccount(101, 1000);

        try {
            acc.withdraw(300);
        } catch (InsufficientFundsException | InvalidAmountException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}