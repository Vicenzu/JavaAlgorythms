package Lezione14;

import java.util.Comparator;

public class Student {
    private final String name;
    private final String surname;
    private final String id;


    public Student(String name, String surname, String id) {
        this.name = name;
        this.surname = surname;
        this.id = id;
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (!(obj instanceof Student)) return false;
        Student s = (Student) obj;

        return s.id.equals(this.id);
    }

    @Override
    public final int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public String toString() {
        return "(" + this.name + ", " + this.surname + ", [" + this.id + "])";
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getId() {
        return id;
    }


    static class StudentComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            int res = o1.getSurname().compareTo(o2.getSurname());
            if (res != 0) return res;
            res = o1.getName().compareTo(o2.getName());
            if (res != 0) return res;
            res = o1.getId().compareTo(o2.getId());

            return res;
        }
    }

}