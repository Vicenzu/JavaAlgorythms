package Lezione5;
import java.time.*;
public class Manager extends Employee{
    private double bonus;

    public Manager() {}

    public Manager(String name, double salary, int y, int m, int d) {
        super(name, salary, y, m, d);
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public final double getSalary() { //non può essere overridden dalle sottoclassi perchè è final
        return super.getSalary() + bonus;
    }


}
