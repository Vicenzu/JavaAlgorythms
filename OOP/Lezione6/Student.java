package Lezione6;

public class Student extends Person {
    private String major;

    public Student(String n, String m) {
        super(n);
        major = m;
    }

    @Override
    public String getDescription() {
        return getName() + " " + major;
    }
}
