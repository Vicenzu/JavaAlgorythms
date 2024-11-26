package Prove.Traccia4;
import java.util.*;
public class Piatto {
    private String codice;
    private String nome;
    private LinkedList<String> ingredienti;
    private LinkedList<Integer> dosi;

    public Piatto(String codice, String nome, LinkedList<String> ingredienti, LinkedList<Integer> dosi) {
        this.codice = codice;
        this.nome = nome;
        this.ingredienti = new LinkedList<>(ingredienti);
        this.dosi = new LinkedList<>(dosi);
    }

    public String getCodice() {
        return codice;
    }

    public String getNome() {
        return nome;
    }

    public LinkedList<String> getIngredienti() {
        return ingredienti;
    }

    public LinkedList<Integer> getDosi() {
        return dosi;
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof Piatto))
            return false;

        Piatto p = (Piatto)o;
        if (p.getCodice().equals(this.codice) && p.getNome().equals(this.nome) && p.getDosi().equals(this.dosi) && p.getIngredienti().equals(this.ingredienti))
            return true;
        return false;
    }

    public String toString() {
        return "Piatto [codice=" + codice + ", nome=" + nome + ", ingredienti=" + ingredienti + ", dosi=" + dosi + "]";
    }
}
