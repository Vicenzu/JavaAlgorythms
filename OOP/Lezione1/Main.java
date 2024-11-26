package Lezione1;
public class Main {
    @SuppressWarnings({ "unused", "null" })
    public static void main(String[] args) {
        Quantity q1 = new Quantity(3);
        var q2 = new Quantity(4); /*Nelle nuove versioni di java quando abbiamo delle variabili locali (quelle allocate 
        nello stack), posso scrivere var, ma solo nel corpo di un metodo e dobbiamo inizializzarlo */
        int max = Quantity.max;
        
        //possiamo anche
        q1 = null; //NULL assegnabile a qualsiasi variabile purchè non primitiva, ed è un'area di memoria dell'heap

        Quantity q3 = new Quantity(4);

        //== confronta gli indirizzi
        boolean b1 = q1 == q2; // true
        boolean b2 = q1 == q3; // false

        //equals va definito all'interno della classe
        boolean b3 = q1.equals(q3); //true
        boolean b4 = q2.equals(q1); //true

        int[] v = {1,2,3}; //in realtà dietro a int[] c'è proprio la classe int[]
        //quindi se facciamo
        int length = v.length; //è proprio una variabile d'istanza final e quindi non è possibile assegnare un valore

        int[][] m = { //in questo caso le matrici sono degli array di array contenenti int, quindi potremmo creare degli array
                      // di lunghezza differente
            {1,2},
            {3,4}
        };



    }
}
