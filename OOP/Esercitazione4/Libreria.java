package Esercitazione4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Libreria{
    private final ArrayList<Libro> libri; //in ordine di inserimento
    private HashMap<Libro, String> prestiti; //key = Libro, value = borrower name

    public Libreria(){
        libri = new ArrayList<Libro>();
    }

    public void aggiungiLibro(Libro l) {
        libri.add(l);
        System.out.println("Libro aggiunto");
    }

    public void cercaPerTitolo(String title) {
        LinkedList<Libro> res = new LinkedList<>();

        for (Libro l : libri) {
            if (l.getTitolo().equals(title)) {
                res.add(l);
            }
        }

        if (res.isEmpty()) {
            System.out.println("Libro non trovato");
        }
        else {
            System.out.println("Ecco i risultati:\n");
            res.forEach(System.out::println);
        }
    }

    public void cercaPerAutore(String autore) {
        LinkedList<Libro> res = new LinkedList<>();
        for (Libro l : libri) {
            if (l.getAutore().equals(autore)) {
                res.add(l);
            }
        }
        if (res.isEmpty()) {
            System.out.println("Libro non trovato");
        }
        else {
            System.out.println("Ecco i risultati:\n");
            res.forEach(System.out::println);
        }
    }

    public void ordinaPerTitolo() {
        ArrayList<Libro> res = new ArrayList<>(libri);
        res.sort(Libro::compareTo);
        res.forEach(System.out::println);
    }

    public void ordinaPerAnno() {
        ArrayList<Libro> res = new ArrayList<>(libri);
        res.sort((l1, l2) -> {return Integer.compare(l2.getAnno(), l1.getAnno());});
        res.forEach(System.out::println);
    }

    public void stampaCatalogo() {
        libri.forEach(System.out::println);
    }

    public boolean presta(Libro l, String nome) {
        if (!l.getDisponibilita()) {
            return false;
        }

        l.setDisponibilita(false);
        prestiti.put(l, nome);
        return true;
    }

    public boolean restituzione(Libro l) {
        if (!prestiti.containsKey(l)) {
            return false;
        }
        l.setDisponibilita(true);
        prestiti.remove(l);
        return true;
    }
}
