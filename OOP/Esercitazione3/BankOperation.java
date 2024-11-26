package Esercitazione3;

public interface BankOperation extends Comparable<BankOperation>{
    public void deposit(double amount);
    public void withdraw(double amount);
    public double getBalance();
}
