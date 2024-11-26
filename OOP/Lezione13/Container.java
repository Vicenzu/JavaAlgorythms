package Lezione13;

import java.util.NoSuchElementException;
import java.util.Iterator;

/* capiamo che la maggior parte dei metodi sono già implementabili all'interno dell'interfaccia
* e ci risparmiamo molto lavoro nello sviluppo delle classi singole */

//simuliamo la List di java
public interface Container<E> extends Iterable<E> {
    //già implementabile
    default int size() {
        int c = 0;

        for (E e : this) {  //promettiamo che this avrà l'iteratore
            c++;
        }

        return c;
    }


    default E get(int index) {
        int i = 0;

        for (E e : this) {
            if (index == i) {
                return e;
            }

            i++;
        }

        throw new NoSuchElementException();
    }


    //non si può fare perché non sappiamo la struttura dati
    E set(int index, E elem);


    default E remove() {
        Iterator<E> it = this.iterator();
        E e = it.next();
        it.remove();
        return e;
    }


    default E remove(int index) {
        int i = 0;
        Iterator<E> it = this.iterator();

        while (it.hasNext()) {
            E e = it.next();

            if (i == index) {
                it.remove();
                return e;
            }

            i++;
        }

        throw new ArrayIndexOutOfBoundsException();
    }


    default boolean remove(E elem) {
        Iterator<E> it = this.iterator();

        while (it.hasNext()) {
            E foundElem = it.next();

            if (foundElem.equals(elem)) {
                it.remove();
                return true;
            }
        }

        return false;
    }


    boolean add(E elem);


    default void clear() {
        Iterator<E> it = this.iterator();

        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }


    default boolean contains(E elem) {
        for (E e : this) {
            if (e.equals(elem)) {
                return true;
            }
        }

        return false;
    }
}
