package Lezione11;

import IO.*;
public class MetodiStatici {
    public static void main(String[] args) {
        Persona p = new Persona();
        IO.println(p);
        IO.println(p.getNome());
        /*Il parametro p è implicito in quanto chiamato come prefisso di getnome() - METODO DINAMICO
        non possiamo evocarli se non esiste l'oggetto p in questo caso
        le occorrenze di "this" all'interno del metodo vengono sostituite in questo caso con "p" */
    
        /*Ma è anche possibile creare metodi in cui va passato come parametro - METODO STATICO
        non richiede un oggetto su cui essere invocato
        usa come prefisso il nome della classe
        
        può essere usato anche se non ci sono oggetti della classe (anche se in questo caso lo prende)
        come parametro) */
    
        Persona.stampa(p);
        p.stampa();

        /*In generale, i getters e setters vengono scritti in forma dinamica, mentre tutti gli altri
        possiamo scriverli come ci piace. Ma in generale, se ad esempio creiamo una classe intesa come
        oggetto (es. Persona), conviene farli dinamici, in quanto la maggior parte dei metodi
        andranno a riguardare l'oggetto di quella classe */
    
        Persona q = Persona.creaPersona();
        IO.println(q);

        //comparazione statica e dinamica
        Persona p1 = new Persona("A", "B", 13);
        Persona p2 = new Persona("C", "D", 15);
        IO.println(p1.etaMinore(p2));
        IO.println(Persona.etaMinore(p1, p2));
    }
}