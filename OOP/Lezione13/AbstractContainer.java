package Lezione13;

public abstract class AbstractContainer<E> implements Container<E> {
    //solo come esempio (non bella)
    //se vogliamo accomunare il calcolo della dimensione
    protected int size;

    @Override
    public int size() {
        return size;
    }

    //tuttavia questa size andrebbe aggiornata ogni volta (dopo una remove, clear, ecc.)

    @Override
    public void clear() {
        Container.super.clear();
        size = 0;
    }


    @Override
    public boolean remove(E elem) {
        boolean res = Container.super.remove(elem);

        if (res) {
            size--;
        }

        return res;
    }


    @Override
    public E remove() {
        E el = Container.super.remove();

        size--;

        return el;
    }


    @Override
    public E remove(int index) {
        if (index <= 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        E el = Container.super.remove(index);
        size--;
        return el;
    }


    //qui per esempio aggiungiamo solo il controllo degli indici
    @Override
    public E get(int index) {
        if (index <= 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return Container.super.get(index);
    }
}
