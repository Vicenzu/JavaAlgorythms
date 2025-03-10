package Lezione12;
import java.util.Collection;

public interface Stack<E>{
    void push(E item);
    E pop();
    E top();
    int size();
    boolean isEmpty();
    boolean isFull();

    //Prende tutti gli oggetti iterable e li pusha dentro lo stack
    // <? extends E> fa in modo che siano presi in input anche i sottotipi di E, quindi è un PRODUCER
    default void pushAll(Iterable<? extends E> src){
        for (E elem : src)
            push(elem);
    }

    // <? super E> prendiamo anche i supertipi, quindi è un CONSUMER
    default void popAll(Collection<? super E> c) {
        while (!isEmpty())
            c.add(pop());
    }
}
