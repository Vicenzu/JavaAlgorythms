package Lezione12;

import oop.range.Range;

public class BoundedStack <E> implements Stack<E> {
    private final Object[] data; //se mettiamo come tipo E[] dobbiamo fare il casting nel costruttore
    private int topIndex;

    public BoundedStack(final int cap) {
        if (cap < 0) throw new IllegalArgumentException();
        //data = (E[]) new Object[cap];    primo metodo di inizializzazione
        data = new Object[cap];
    }

    public BoundedStack() {
        data = new Object[10];
    }

    @Override
    public void push(E item) {
        if (isFull()) throw new FullStackException("Stack is full");

        data[topIndex] = item;
        topIndex++;
    }

    @Override
    public E pop() {
        if (isEmpty()) throw new EmptyStackException("Stack is empty");
        topIndex--;
        return (E) data[topIndex];
    }

    @Override
    public E top(){
        if (isEmpty()) throw new EmptyStackException("Stack is empty");
        return (E) data[topIndex-1];
    }

    @Override
    public int size() {
        return topIndex;
    }

    @Override
    public boolean isEmpty() {
        return topIndex == 0;
    }

    @Override
    public boolean isFull() {
        return topIndex == data.length;
    }

    public int capacity() {
        return data.length;
    }

}
