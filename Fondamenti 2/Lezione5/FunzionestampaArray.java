import IO.*;
public class FunzionestampaArray {

    //FUNZIONE CHE STAMPA UN ARRAY
    public static void stampaArray(int[] arraydastampare) {
        IO.print("[");
        for (int i = 0; i<arraydastampare.length; i++) {
            IO.print(arraydastampare[i]);
            if (i<arraydastampare.length-1)
                IO.print("; ");
        }
        IO.print("]");
    }

    public static void main(String[] args) {
        
        int [] ai = {6, 3, 8, 2}; //per popolare il vettore non da input (ma al livello di memoria funziona allo stesso modo)
        int [] ai2 = {3, 4, 1, 7};

        /*Se provassimo a fare semplicemente la print del vettore, ci restituirebbe solo l'indirizzo di memoria 
        out -> [I@723279cf -> analizzato: '[' ci indica il tipo, 'I@' ci dice che quello che cerchiamo si trova
        nell'indirizzo di memoria: '723279cf' */
        IO.println(ai); 

        //Printo in output ogni elemento del vettore ai
        IO.print("[");
        for (int i = 0; i<ai.length; i++) {
            IO.print(ai[i]);
            if (i<ai.length-1)
                IO.print("; ");
        }
        IO.println("]");

        //Lo devo rifare per tutti i vettori
        IO.print("[");
        for (int i = 0; i<ai2.length; i++) {
            IO.print(ai2[i]);
            if (i<ai2.length-1)
                IO.print("; ");
        }
        IO.println("]");

        //RICHIAMANDO LA FUNZIONE stampaArray()
        stampaArray(ai);

    }
}