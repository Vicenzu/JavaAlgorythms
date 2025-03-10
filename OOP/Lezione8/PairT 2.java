package Lezione8;

/*Mettendo <T> noi diciamo che si può utilizzare qualsiasi tipo purché sia uguale*/
public class PairT<T> {
    private T first;
    private T second;

    public PairT() {}

    public PairT(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }


}
