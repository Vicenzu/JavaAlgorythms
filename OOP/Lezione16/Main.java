package Lezione16;

import Lezione15.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        String[] a = {"aaa", "cajdmi", "dovkn", "dcwmok", "ceoml"};

        //QUESTO COMPARATOR NON VA BENE, perchè non fa un comparison totale
//        Comparator<String> comp = new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                if (o1.length() < o2.length()) return -1;
//                else if (o1.length() > o2.length()) return 1;
//                else return 0;
//            }
//        };

        //perciò ne creo uno che ordina prima in base alla lunghezza e poi in ordine alfabetico
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() < o2.length()) return -1;
                else if (o1.length() > o2.length()) return 1;
                else return o1.compareTo(o2);
            }
        };

        //Possiamo utilizzare l'istanza dell'innerclass anonima anche in questo modo
        int k = comp.compare(a[0], a[1]);

        TreeSet<String> set = new TreeSet<>(comp); //se metto comp tra parentesi utilizzerà questo metodo di confornto
        for (String s : a)
            set.add(s);
        System.out.println(set);

        //Dato che il TreeSet è di String allora i tipi della lambda expression possono essere impliciti
        TreeSet<String> set1 = new TreeSet<>((o1, o2) -> { //lambda expression definita come () -> {}
            if (o1.length() < o2.length()) return -1;
            else if (o1.length() > o2.length()) return 1;
            else return o1.compareTo(o2);});
    }

    /*Mentre prima il comparator era un innerclass anonima, adesso abbiamo messo una lambda expression
    * in modo tale da poterlo riutilizzare */
    Comparator<String> comp1 = (o1, o2) -> {
            if (o1.length() < o2.length()) return -1;
            else if (o1.length() > o2.length()) return 1;
            else return o1.compareTo(o2);
        };

    //Method Reference
    Comparator<String> comp2 = String :: compareTo;


    String[] a1 = new String[]{"a", "b", "c", "d"};
    Person[] ap1 = buildFromID(a1, Person :: new);

    //oppure usando le lambda
    Person[] ap2 = buildFromID(a1, s -> {
        return new Person(s);
    });

    static Person[] buildFromID(String[] iterable, Function<String, Person> f) {
        ArrayList<Person> ap = new ArrayList<>();

        for (String str : iterable) {
            ap.add(f.apply(str));
        }
        return ap.toArray(new Person[ap.size()]);
    }



}
