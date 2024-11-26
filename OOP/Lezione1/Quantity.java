package Lezione1;

// creiamo la classe quantità
/*NON possiamo utilizzare un semplice int in quanto potrebbe assumere valori non utilizzabili, 
 * perciò usiamo il final int che ci obbliga a inizializzare il valore nel costruttore o direttamente nell'istanza
*/

public class Quantity {
    public static final int max = 1000; /*La quantità max non verrà riprodotta in ogni istanza di Quantity
    ma sarà una in comune per ogni istanza della classe, poichè STATIC */
    private final int val;
    /* INCAPSULATION - significa che è importante che i campi della classe vengano controllati e modificati 
     * solo dentro la classe
     * 
     * INFORMATION HIDING - nascondiamo il fatto che sia un intero all'esterno
     */

    public Quantity (int v) {
        if (v <= 0 || v > max)
            System.exit(1); //esempio brutto
        val = v;
    }

    public int getVal() {
        return val;
    }

    

}
