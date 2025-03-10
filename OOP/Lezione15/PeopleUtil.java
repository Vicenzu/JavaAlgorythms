package Lezione15;

import java.util.List;

public class PeopleUtil {

    //Facendo in questo modo possiamo prendere in input anche con un metodo statico un tipo generico
    //Inoltre se mettiamo Comparable<T>, l'oggetto può essere anche un sottotipo di t COMPARABLE
    //<T extends Comparable<? super T>> 
    /**
     *
     * @param list
     * @return la persona con l'id min
     * @param <T>
     */
    public static <T extends Comparable<? super T>> T min(List<T> list) {
        T min = null;
        for (T person : list) {
            if (min == null || person.compareTo(min) < 0) {
                min = person;
            }
        }
        return min;
    }
}
