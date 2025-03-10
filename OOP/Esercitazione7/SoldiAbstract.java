package Esercitazione7;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public abstract class SoldiAbstract implements Soldi {
    protected List<Denaro> sommaDenaro;

    public SoldiAbstract(List<Denaro> lista) {
        sommaDenaro = lista;
    }

    public void add(Denaro d) {
        if (!sommaDenaro.contains(d))
            sommaDenaro.add(d);
        for (Denaro den : sommaDenaro) {
            if (den.compareTo(d) == 0)
                den.setQuantita(den.getQuantita() + d.getQuantita());
        }
        Collections.sort(sommaDenaro);
        Collections.reverse(sommaDenaro);
    }

    public void add(Soldi s) {
        for (Denaro d : s)
            add(d);
    }

    public void sub(Denaro d) {
        if (!sommaDenaro.contains(d)) throw new IllegalArgumentException("Denaro non trovabile");
        for (Denaro den : sommaDenaro) {
            if (den.compareTo(d) == 0) {
                if (den.getQuantita() > d.getQuantita())
                    den.setQuantita(den.getQuantita() - d.getQuantita());
                else if (den.getQuantita() == d.getQuantita())
                    sommaDenaro.remove(den);
                else
                    throw new IllegalArgumentException("Denaro non sufficiente");
            }
        }
    }

    public void sub(Soldi s) {
        for (Denaro den : s) {
            this.sub(den);
        }
    }

    public List<Denaro> paga_mi(Soldi prezzo, Soldi ricevuti) {
        if (prezzo.totale() > ricevuti.totale()) throw new IllegalArgumentException("Cujjiuni m'è dari cchiu sordi");

        LinkedList<Denaro> backup = new LinkedList<>(this.sommaDenaro);

        this.add(ricevuti);
        double resto = ricevuti.totale()- prezzo.totale();
        LinkedList<Denaro> res = new LinkedList<>();

        if (resto == 0) return res;
        for (Denaro d : this) {
            if (d.getValore() <= resto && resto >= 0.01) {
                int pezzi = (int) Math.floor(resto / d.getValore()); //quanti pezzi di quella taglia deve restituire
                if (d.getQuantita() >= pezzi) {     //controllo se ne ho abbastanza o almeno 1
                    resto -= pezzi*d.getValore();   //tolgo dal resto quelli già dati
                    Denaro curr = new DenaroConcreto(d.getValore(),pezzi); //totale di pezzi che devo dare
                    res.add(curr);
                    this.sub(curr);
                }
                res.add(d);
                this.sub(d);
                resto -= d.getValore()*d.getQuantita();
            }
        }
        if (resto > 0.01 || resto < -0.01) {
            this.sommaDenaro.clear();
            this.sommaDenaro.addAll(backup);
            throw new RuntimeException("Non ne ho abbastanza");
        }

        return res;
    }
}
