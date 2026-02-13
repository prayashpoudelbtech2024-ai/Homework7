import java.util.ArrayList;

class InsufficientFundsException extends Exception {

    InsufficientFundsException(String message) {
        super(message);
    }
}

class Account {

    String accountNumber;
    String accountHolderName;
    double balance;

    Account(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance = balance + amount;
        System.out.println(amount + " deposited successfully.");
    }

    void withdraw(double amount) throws InsufficientFundsException {

        if (amount > balance) {
            throw new InsufficientFundsException("Error: Insufficient balance.");
        } else {
            balance = balance - amount;
            System.out.println(amount + " withdrawn successfully.");
        }
    }

    void transfer(Account targetAccount, double amount) throws InsufficientFundsException {

        if (targetAccount == null) {
            System.out.println("Invalid target account.");
            return;
        }

        if (amount > balance) {
            throw new InsufficientFundsException("Error: Not enough balance to transfer.");
        }

        balance = balance - amount;
        targetAccount.balance = targetAccount.balance + amount;

        System.out.println(amount + " transferred to " + targetAccount.accountHolderName);
    }

    void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: " + balance);
        System.out.println("--------------------------");
    }
}

class Bank {

    ArrayList<Account> accounts = new ArrayList<Account>();

    void createAccount(String accountNumber, String name, double balance) {

        Account acc = new Account(accountNumber, name, balance);
        accounts.add(acc);

        System.out.println("Account created for " + name);
    }

    Account getAccount(String accountNumber) {

        for (Account acc : accounts) {
            if (acc.accountNumber.equals(accountNumber)) {
                return acc;
            }
        }

        return null;
    }

    void displayAllAccounts() {

        System.out.println("\nAll Bank Accounts:");

        for (Account acc : accounts) {
            acc.displayAccountDetails();
        }
    }
}

public class Main4 {

    public static void main(String[] args) {

        Bank bank = new Bank();

        bank.createAccount("101", "Prayash", 5000);
        bank.createAccount("102", "Ram", 3000);

        Account acc1 = bank.getAccount("101");
        Account acc2 = bank.getAccount("102");

        acc1.deposit(1000);

        try {
            acc1.withdraw(7000);
        }
        catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

        try {
            acc1.transfer(acc2, 2000);
        }
        catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

        bank.displayAllAccounts();
    }
}
