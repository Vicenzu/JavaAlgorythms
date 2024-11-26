package Lezione5;

import java.time.*;

public class Employee {
    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employee() {}

    public Employee(String name, double salary, int y, int m, int d) {
        this.name = name;
        this.salary = salary;
        hireDay = LocalDate.of(y, m, d);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double percentage) {
        salary += (salary*percentage)/100;
    }

}