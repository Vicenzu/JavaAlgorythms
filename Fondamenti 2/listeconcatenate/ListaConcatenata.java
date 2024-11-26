package listeconcatenate;
class Nodo <T> {
    private T info;
    private Nodo<T> succ;

    public Nodo() {
        this.info = null;
        this.succ = null;
    }

    public Nodo(T info, Nodo<T> succ) {
        this.info = info;
        this.succ = succ;
    }

    public T getInfo() {
        return info;
    }
    public void setInfo(T info) {
        this.info = info;
    }
    public Nodo<T> getSucc() {
        return succ;
    }
    public void setSucc(Nodo<T> succ) {
        this.succ = succ;
    }

    public String toString() {
        return "" + info;
    }
}

public class ListaConcatenata <X> {
    private Nodo<X> testa;
    private Nodo<X> coda;
    private int lunghezza;

    private void inizializza() {
        this.testa = null;
        this.coda = null;
        this.lunghezza = 0;
    }

    public ListaConcatenata() {
        inizializza();
    }

    public ListaConcatenata (X[] a) {
        if (a == null || a.length == 0) {
            inizializza();
        }
        else {
            for (int i=0; i<a.length; i++)
                this.aggiungiInCoda(a[i]);
        }
    }

    //Shallow copy, ma purtroppo non possiamo fare di più per il momento (diobestia)
    public  ListaConcatenata (ListaConcatenata<X> l) {
        if (l == null || l.lunghezza == 0) {
            inizializza();
        }
        for (Nodo<X> it=l.testa; it!=null; it=it.getSucc()) 
            this.aggiungiInCoda(it.getInfo());
    }

    public String toString() {
        String s = "[";
        for (Nodo<X> it=this.testa; it!=null; it=it.getSucc()) {
            if (it.getSucc() != null)
                s += it + ", ";
            else    
                s += it;
        }
        return s + "]";
    }

    public Nodo<X> getTesta() {
        return testa;
    }

    public void setTesta(Nodo<X> testa) {
        this.testa = testa;
    }

    public Nodo<X> getCoda() {
        return coda;
    }

    public void setCoda(Nodo<X> coda) {
        this.coda = coda;
    }

    public int getLunghezza() {
        return lunghezza;
    }

    public void setLunghezza(int lunghezza) {
        this.lunghezza = lunghezza;
    }

    public void aggiungiInTesta(X info) {
        Nodo<X> nuovaTesta = new Nodo<>(info, this.testa);

        this.testa = nuovaTesta;
        if (this.lunghezza == 0) 
            this.coda = nuovaTesta;

        this.lunghezza++;
    }

    public void aggiungiInCoda(X info) {
        Nodo<X> nuovaCoda = new Nodo<>(info, null);

        if (this.lunghezza == 0)
            this.testa = nuovaCoda;
        else
            this.coda.setSucc(nuovaCoda);

        this.coda = nuovaCoda;

        this.lunghezza++;
    }

    public boolean rimuoviTesta() {
        if (this.lunghezza == 0 || this == null)
            return false;
        
        this.testa = this.testa.getSucc();

        if (this.lunghezza == 1)
            this.coda = null;
        
        lunghezza--;

        return true;
    }

    public boolean rimuoviCoda() {
        if (lunghezza == 0 || this == null)
            return false;
        else if (lunghezza == 1) {
            this.testa = null;
            this.coda = null;
        }
        else {
            for (Nodo<X> it=this.testa; it!=null; it=it.getSucc())
                if (it.getSucc() == this.coda) {
                    it.setSucc(null);
                    this.coda = it;
                } 
        }
        this.lunghezza--;
        return true;
    }

    public boolean aggiungiInPosizione(int pos, X info) {
        if (pos < 0 || pos > this.lunghezza)
            return false;
        if (pos == 0)
            this.aggiungiInTesta(info);
        if (pos == this.lunghezza)
            this.aggiungiInCoda(info);
        
        Nodo<X> it=this.testa;
        for (int i = 1; i<pos; i++) {
            if (i == pos) {
                Nodo<X> nuovoNodo = new Nodo<>(info, it.getSucc());
                it.setSucc(nuovoNodo);
                this.lunghezza++;
            }
            it=it.getSucc();
        }
        return true;
    }    

    public boolean modificaInPosizione(X info, int pos) {
        if (pos < 0 || pos > this.lunghezza)
            return false;
        if (this.lunghezza == 0)
            return false;
        else {
            int i = 0;
            for (Nodo<X> it=this.testa; it!=null; it=it.getSucc()) {
                if (i == pos)
                    it.setInfo(info);
                else
                    i++;
            }
        }
        return true;
    }

    public boolean rimuoviInPosizione(int pos) {
        if (pos < 0 || pos > this.lunghezza)
            return false;
        if (this.lunghezza == 0)
            return false;
        if (pos == 0)
            this.rimuoviTesta();
        if (pos == this.lunghezza-1)
            this.rimuoviCoda();

        int i = 1;
        for (Nodo<X> it=this.testa; it!=null; it=it.getSucc()) {
            if (i == pos) {
                it.setSucc(it.getSucc().getSucc());
                this.lunghezza--;
            }
            i++;
        }
        return true;
    }

    public static <X extends Comparable<X>> boolean crescente (ListaConcatenata<X> l) {
        if (l.lunghezza == 0 || l == null)
            return true;
        else {
            for (Nodo<X> it=l.testa; it.getSucc()!=null; it=it.getSucc()) {
                if (it.getInfo().compareTo(it.getSucc().getInfo()) > 0)
                    return false;
            }
        }
        return true;
    }

    public static <X extends Comparable<X>> boolean crescenteRic(ListaConcatenata<X> l) {
        return crescenteRic(l.testa);
    } 
    private static <X extends Comparable<X>> boolean crescenteRic(Nodo<X> n) {
        if (n == null || n.getSucc() == null)
            return true;
        if (n.getInfo().compareTo(n.getSucc().getInfo()) > 0)
            return false;
        
        return crescenteRic(n.getSucc());
    }   

    public boolean equals(ListaConcatenata<X> l) {
        if (this == l)
            return true;
        if (this.lunghezza != l.lunghezza)
            return false;
        
        Nodo<X> it = this.testa;
        Nodo<X> it1 = l.testa;
        for (int i=0; i<this.lunghezza; i++) {
            if (!it.getInfo().equals(it1.getInfo()))
                return false;
            else {
                it=it.getSucc();
                it1=it1.getSucc();
            }
        }
        return true;
    }

    public void svuota() {
        inizializza();
    } //Quando si svuota la lista entra in azione il Garbage Collector, che simultaneamente all'esecuzione controlla
    // le variabili non utilizzate nell'heap e le cancella

    public X[] adArray() {
        @SuppressWarnings("unchecked") //Serve per eliminare l'avviso
        X[] res = (X[])(new Object[this.lunghezza]); //NON SI PUO' SCRIVERE "new X[this.lunghezza]", perchè java non permette la creazione di array di tipo generico 
        int i = 0;
        for (Nodo<X> it=this.testa; it!=null; it=it.getSucc()) {
            res[i] = it.getInfo();
            i++;
        }
        return res;
    }

    

}
