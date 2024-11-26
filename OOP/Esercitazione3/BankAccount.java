package Esercitazione3;

public class BankAccount extends AbstractBankAccount{
    public BankAccount(int accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void deposit(double amount) {

    }

    @Override
    public void withdraw(double amount) {

    }

    @Override
    public double getBalance() {
        return 0;
    }

    @Override
    public int compareTo(BankOperation o) {
        return 0;
    }
}
