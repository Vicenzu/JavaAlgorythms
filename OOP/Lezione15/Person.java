package Lezione15;

public class Person implements Comparable<Person> {
    private String id;

    public Person(String id) {
        this.id = id;
    }

    @Override
    public int compareTo(Person o) {
        return id.compareTo(o.id);
    }
}
