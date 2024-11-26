package Lezione12;

import oop.range.Range;

public class UnboundedStackArray<E> implements Stack<E> {
    private Object[] data; //se mettiamo come tipo E[] dobbiamo fare il casting nel costruttore
    private int topIndex;
    public static final int MIN_CAP = 10;

    public UnboundedStackArray(int cap) {
        data = new Object[Math.max(cap, MIN_CAP)];
    }

    @Override
    public void push(E e) {
        if (topIndex == data.length) reallocate();
        data[topIndex++] = e;
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
        return topIndex == Integer.MAX_VALUE;
    }

    public int capacity() {
        return data.length;
    }

    private void reallocate() {
        Object[] newData = new Object[data.length * 2];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }
    //Buon metodo ma meglio utilizzare le liste

}
