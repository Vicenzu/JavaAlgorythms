package Esercitazione3;

public abstract class AbstractBankAccount implements BankOperation{
    private int accountNumber;
    private double balance;

    public AbstractBankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
}