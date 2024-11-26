package Lezione12;
import oop.range.Range;

import java.util.*;

public class ListStack1<E> implements Stack<E> {
    private List<E> list;

    public ListStack1() {
        list = new LinkedList<E>();
    }

    @Override
    public void push(E item) {
        list.addLast(item);
    }

    @Override
    public E pop() {
        return list.removeLast();
    }

    @Override
    public E top() {
        return list.getLast();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }


}
