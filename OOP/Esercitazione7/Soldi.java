package Esercitazione7;


import java.util.*;

public interface Soldi extends Comparable<Soldi>, Iterable<Denaro>{
    default double totale() {
        double tot = 0.0;
        for (Denaro d : this)
            tot+=d.getSomma();
        return tot;
    }
    void add(Denaro d);
    void add(Soldi s);
    void sub(Denaro d);
    List<Denaro> paga_mi(Soldi s1, Soldi s2);

    default int CompareTo(Soldi s) {
        return Double.compare(this.totale(), s.totale());
    }

}
