package Lezione13;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedContainer<E> extends AbstractContainer<E> {
    private Node<E> head;

    @Override
    public E set(int index, E elem) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        //if (index == size) add(elem) return null

        Node<E> cur = head;
        Node<E> prev = null;
        int i = 0;

        while (i < index) {
            i++;
            prev = cur;
            cur = cur.next;
        }

        if (i < size) {
            E e = cur.info;
            cur.info = elem;
            return e;
        }

        //se aggiungo in ultima posizione (i == size)
        Node<E> newNode = new Node<>(elem, null);
        if (prev == null) {
            head = newNode;
        } else {
            prev.next = newNode;
        }

        size++;
        return null;
    }

    @Override
    public boolean add(E elem) {
        Node<E> prev = null;
        Node<E> cur = head;

        while (cur != null) {
            prev = cur;
            cur = cur.next;
        }

        Node<E> newNode = new Node<>(elem, null);

        if (prev == null) { //sono in testa
            head = newNode;
        } else {
            prev.next = newNode;
        }

        size++;
        return true;
    }



    @Override
    public Iterator<E> iterator() {
        return new LCIterator();
    }



    //inner-class NON-STATICA, ovvero si porta il riferimento all'oggetto genitore
    //OSS: non devo mettere il parametro di tipo in quanto già noto
    private class LCIterator implements Iterator<E> {
        private Node<E> prev;
        private Node<E> cur;
        private boolean removeOK = false;


        @Override
        public boolean hasNext() {
            if (cur == null) {
                return head != null;
            }

            return cur.next != null;
        }


        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            prev = cur;

            if (cur == null) {
                cur = head;
            } else {
                cur = cur.next;
            }

            E res = cur.info;

            removeOK = true;
            return res;
        }


        @Override
        public void remove() {
            if (!removeOK) {
                throw new IllegalStateException();
            }

            removeOK = false;

            if (cur == head) {
                head = head.next;
            } else {
                prev.next = cur.next;
            }

            cur = cur.next;
            size--;
        }
    }



    private static class Node<E> {
        E info;
        Node<E> next;

        public Node(E info, Node<E> next) {
            this.info = info;
            this.next = next;
        }
    }
}
