package Lezione2;

/* Supponiamo di dover creare una classe quantità per gestire la quantità di ordini di un ecommerce
 * ATTENZIONE: Non possiamo usare direttamente un int in quanto verranno ammessi anche valori negativi,
 * e ciò potrebbe creare delle vulnerabilità nel nostro sistema
 */

public class Quantity {
    private final int val; //final indica che non potrà più essere modificata, però va inizializzata nel costruttore
    /* INCAPSULATION - è importante che i campi della classe vengano controllati e modificati solo ed 
     * esclusivamente dentro la classe
     * 
     * INFORMATION HIDING - nascondo il fatto che sia un intero all'esterno
     */


    public static final int MAX = 1000;
    /* la quantità MAX non è riprodotta in ogni istanza di Quantity, ma sarà una in comune per ogni istanza
     * della classe, in quanto è STATIC
     */



    public Quantity(int v) {
        //inserisco i criteri del valore
        if (v <= 0 || v > MAX)
            System.exit(1);     //brutta, ma solo per esempio (per ora)
        
        this.val = v;
    }

    public int getVal() {
        return this.val;
    }
}

