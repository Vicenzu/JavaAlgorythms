package Esercitazione4;

import java.util.Objects;

public class Libro implements Comparable<Libro> {
    private String titolo, autore, genere;
    private int anno;
    private boolean disponibile;

    public Libro() {}

    public Libro(String titolo, String autore, String genere, int anno) {
        this.titolo = titolo;
        this.autore = autore;
        this.genere = genere;
        if (anno < 0) throw new IllegalArgumentException();
        this.anno = anno;
        disponibile = true;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        if (anno < 0) throw new IllegalArgumentException();
        this.anno = anno;
    }

    public boolean getDisponibilita() {
        return disponibile;
    }

    public void setDisponibilita(boolean disponibili) {
        this.disponibile = disponibili;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o == this) return true;
        if (o instanceof Libro l) {
            return this.titolo.equals(l.titolo) && this.autore.equals(l.autore) && this.genere.equals(l.genere) && this.anno == l.anno;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int res = 13;
        res = 31 * res + (titolo == null? 0 : titolo.hashCode());
        res = 31 * res + (autore == null? 0 : autore.hashCode());
        res = 31 * res + (genere == null? 0 : genere.hashCode());
        res = 31 * res + anno;
        return res;
    }

    @Override
    public String toString() {
        return "Title: " + titolo + ", Author: " + autore + ", Genre: " + genere + ", Year: " + anno;
    }

    /**
     * Compares two books by their title
     * @param o the book to be compared.
     * @return 0 if same title, a negative number if o.title follows this.title, a positive number if this.title follows o.title
     */
    @Override
    public int compareTo(Libro o) {
        return this.titolo.compareTo(o.titolo);
    }
}
