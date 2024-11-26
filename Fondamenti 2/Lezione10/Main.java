//CREAZIONE DI TIPI DEFINITI DALL'UTENTE
import IO.*;
public class Main {
    
    public static void main(String[] args) {
        Persona p = new Persona();  /* Persona() si chiama "costruttore" - costruisce dentro l'heap una variabile
                                    per ogni variabile definita in Persona*/

        // "p" si chiama OGGETTO PERSONA (ovvero la variabile di un tipo definito da noi)
        
        //In questo caso stamperà "none none 0" perchè non ha nessuna variabile salvata
        IO.println(p.nome+" "+p.cognome+" "+p.eta);

        p.nome = "Dante";
        p.cognome = "Alighieri";
        p.eta = 40;
        //Per quanto riguarda quello che avviene in memoria la classe lavora allo stesso modo degli array
        IO.println(p.nome+" "+p.cognome+" "+p.eta);
        IO.println(p); //Se proviamo a stampare la variabile "p" del tipo "Persona" in output avremo "Persona@66a29884"
 
        Persona q = new Persona("Vincenzo", "Calogero", 19);
        IO.println(q.nome+" "+q.cognome+" "+q.eta);

        IO.println(q.soloNomeECognome());

        IO.println(q.toString());
        IO.println(q); //questo stampa direttamente il metodo toString() perchè java lo riconosce

        //Metodo leggiDaInput()
        Persona k = new Persona();
        k.leggiDaInput();
        IO.println(k);
    
    
    
    
    }
}