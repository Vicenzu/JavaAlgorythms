package Lezione15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class Main {
    public static void main(String[] args) {
        Person pippo = new Person("230958");
        Person pluto = new Person("12345");
        Person topolino = new Person("00123");
        Student ciccio = new Student("00001");

        System.out.println(pluto.compareTo(topolino));
        System.out.println(topolino.compareTo(ciccio));

        ArrayList<Person> a = new ArrayList<Person>();
        a.add(pippo);
        a.add(pluto);
        a.add(topolino);
        a.add(ciccio);
        System.out.println("\n"+PeopleUtil.min(a));

        ArrayList<Student> as = new ArrayList<>();
        as.add(ciccio);
        as.add(new Student("32492"));
        as.add(new Student("00000"));

        System.out.println("\n"+PeopleUtil.min(as));
    }
}
