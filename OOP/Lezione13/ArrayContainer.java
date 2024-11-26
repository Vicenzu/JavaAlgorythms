package Lezione13;

import java.util.Iterator;

public class ArrayContainer<E> extends AbstractContainer<E> {
    private E[] array;
    private int size;

    public ArrayContainer() {}

    public ArrayContainer(E[] array) {
        if (array != null)
            System.arraycopy(array, 0, this.array, 0, array.length);

    }

    public ArrayContainer(int size) {
        this.array = (E[]) new Object[size];
    }

    public E set(int index, E element) {
        if (index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException(index);

        E old = array[index];
        array[index] = element;
        return old;
    }

    public E get(int index) {
        if (index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException(index);
        return array[index];
    }
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException(index);

        E oldEl = array[index];
        E[] newArray = (E[]) new Object[size-1];
        System.arraycopy(array, 0, newArray, 0, index-1);
        System.arraycopy(array, index+1, newArray, index, size-index-1);
        return oldEl;
    }

    @Override
    public boolean add(E elem) {
        E[] newArray = (E[]) new Object[size*2];
        System.arraycopy(array, 0, newArray, 0, size);
        newArray[size] = elem;
        return true;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E add(int index, E element) {
        if (index < 0 || index > size)
            throw new ArrayIndexOutOfBoundsException(index);

        if (index == 0) {
            E[] newArray = (E[]) new Object[size*2];
            newArray[0] = element;
            System.arraycopy(array, 0, newArray, 1, index);
        }
        else if (index == size) {
            add(element);
        }
        else {
            E[] newArray = (E[]) new Object[size*2];
            System.arraycopy(array, 0, newArray, 0, index-1);
            newArray[index] = element;
            System.arraycopy(array, index, newArray, index+1, size-index);
        }
        return element;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator();
    }
    private class ArrayIterator implements Iterator<E> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public E next() {
            E curr = array[index];
            index++;
            return curr;
        }
    }
}
