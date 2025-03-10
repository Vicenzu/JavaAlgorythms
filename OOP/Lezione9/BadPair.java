package Lezione9;
//Tipi GENERICI - esempio brutto, con Object, che è troppo generico
public class BadPair {
    private Object first;
    private Object second;

    public BadPair(Object first, Object second) {
        this.first = first;
        this.second = second;
    }

    public Object getFirst() {
        return first;
    }

    public Object getSecond() {
        return second;
    }

    public void setFirst(Object first) {
        this.first = first;
    }

    public void setSecond(Object second) {
        this.second = second;
    }
}
