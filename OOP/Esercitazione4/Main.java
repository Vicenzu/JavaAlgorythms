package Esercitazione4;

public class Main {
    public static void main(String[] args) {
        Libro libro1 = new Libro("Il Signore degli Anelli", "J.R.R. Tolkien", "Fantasy", 1954);
        Libro libro2 = new Libro("1984", "George Orwell", "Dystopian", 1949);
        Libro libro3 = new Libro("Cime tempestose", "Emily Brontë", "Classico", 1847);
        Libro libro4 = new Libro("Il Gattopardo", "Giuseppe Tomasi di Lampedusa", "Storico", 1954);
        Libro libro5 = new Libro("Orgoglio e Pregiudizio", "Jane Austen", "Romance", 1813);

        Libreria libreria = new Libreria();
        libreria.aggiungiLibro(libro1);
        libreria.aggiungiLibro(libro2);
        libreria.aggiungiLibro(libro3);
        libreria.aggiungiLibro(libro4);
        libreria.aggiungiLibro(libro5);

        libreria.stampaCatalogo();
        System.out.println("\n");
        libreria.ordinaPerAnno();

    }
}
