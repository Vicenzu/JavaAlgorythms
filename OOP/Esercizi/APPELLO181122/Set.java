package Esercizi.APPELLO181122;

public interface Set<T> extends Iterable<T> {
    int size();
    boolean clear();
    void add(T x);
    void remove(T x);
    Set<T> factory(); //ritorna un oggetto di tipo set da dare all'utente
    Set<T> union(Set<T> s); //unione tra due set ordinata, uno è this l'altro è s e da un nuovo set
    Set<T> difference(Set<T> s); //elementi di this non appartenenti a s

}
