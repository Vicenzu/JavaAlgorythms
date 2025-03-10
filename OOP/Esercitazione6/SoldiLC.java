package Esercitazione6;

import Esercitazione7.*;

import java.util.AbstractList;
import java.util.Iterator;

public class SoldiLC extends SoldiAbstract {

    public SoldiLC () {
        super(new MyLinkedList<>());
    }

    @Override
    public int compareTo(Soldi o) {
        return 0;
    }

    @Override
    public Iterator<Denaro> iterator() {
        return null;
    }
}

class MyLinkedList<T> extends AbstractList<T> implements Iterable<T> {
    private Node<T> head;
    private int size;

    public MyLinkedList() {}

    @Override
    public T get(int index) {
        checkIndex(index);
        return getNode(index).info;
    }

    @Override
    public int size() {
        return size;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
    }

    private Node<T> getNode(int index) {
        checkIndex(index);
        var curr = head;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                return curr;
            }
            curr = curr.next;
        }
        throw new RuntimeException();
    }

    @Override
    public boolean add(T info) {
        if (head == null) {
            head = new Node<T>(null, info);
        } else {
            var curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = new Node<>(null, info);
        }
        return true;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> curr;

            @Override
            public boolean hasNext() {
                return curr.next!=null;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new IllegalStateException();
                var currInfo = curr.info;
                curr = curr.next;
                return currInfo;
            }
        };
    }

    private static class Node<T> {
        private Node<T> next;
        private T info;

        public Node(){}

        public Node(Node<T> next, T info) {
            this.next = next;
            this.info = info;
        }
    }
}