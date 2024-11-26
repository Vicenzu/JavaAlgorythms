package Lezione14;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Comparator<Student> c = new Student.StudentComparator();
        Set<Student> students = new TreeSet<Student>(c);


        //ANONYMOUS INNER CLASS
        Comparator<Student> comp = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return 0;
            }
        };


        var s1 = new Student("A", "A", "23421");
        var s2 = new Student("B", "B", "256721");
        var s3 = new Student("C", "C", "675671");
        var s4 = new Student("D", "D", "2334345");
        var s5 = new Student("E", "E", "2364561");
        var s6 = new Student("F", "F", "457561");

        students.add(s1);
        System.out.println(students);
        students.add(s2);
        System.out.println(students);
        students.add(s3);
        System.out.println(students);
        students.add(s4);
        System.out.println(students);
        students.add(s5);
        System.out.println(students);
        students.add(s6);
        System.out.println(students);


    }
}