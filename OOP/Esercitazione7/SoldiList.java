package Esercitazione7;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SoldiList extends SoldiAbstract{

    public SoldiList() {
        super(new LinkedList<>());
    }

    public SoldiList(List<Denaro> l) {
        super(new LinkedList<>());
        if (l != null)
            this.sommaDenaro.addAll(l);
        Collections.sort(this.sommaDenaro);
        Collections.reverse(this.sommaDenaro);
    }


    @Override
    public Iterator<Denaro> iterator() {
        return this.sommaDenaro.iterator();
    }

    @Override
    public int compareTo(Soldi o) {
        return Double.compare(this.totale(), o.totale());
    }
}
