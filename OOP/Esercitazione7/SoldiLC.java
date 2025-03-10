package Esercitazione7;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class SoldiLC extends SoldiAbstract {
    private Lista<Denaro> lista;

    public SoldiLC() {
        super(new Lista<Denaro>());
    }

    public Iterator<Denaro> iterator() {
        return lista.iterator();
    }

    @Override
    public int compareTo(Soldi o) {
        return 0;
    }
}

class Lista<T extends Comparable<? super T>> extends AbstractList<T> implements Iterable<T> {
    private Nodo<T> head;
    private Nodo<T> tail;
    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(int index, T e) {
        if (index < 0 || index > this.size)
            throw new IndexOutOfBoundsException();
        if (this.size == 0)
            throw new NoSuchElementException();

        Nodo<T> newN = new Nodo<>(e, null);
        if (index == 0) {
            newN.setNext(head);
            head = newN;
        }
        if (index == this.size - 1) {
            tail.setNext(newN);
            tail = newN;
        }

        Nodo<T> curr = head;
        for (int i = 1; i<size; i++) {
            if (i == index) {
                curr.setNext(newN);
                newN.setNext(curr.getNext());
            }

            curr = curr.getNext();
        }
        size++;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > this.size)
            throw new IndexOutOfBoundsException();
        if (this.size == 0)
            throw new NoSuchElementException();
        int i = 0;
        for (Nodo<T> n = head; n!=null; n=n.getNext()) {
            if (i == index)
                return n.getInfo();
            i++;
        }
        throw new IndexOutOfBoundsException();
    }
}


class Nodo<T extends Comparable<? super T>> {
    private T info;
    private Nodo<T> next;

    public Nodo(T info, Nodo<T> next) {
        this.info = info;
        this.next = next;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public void setNext(Nodo<T> next) {
        this.next = next;
    }

    public Nodo<T> getNext() {
        return next;
    }
}