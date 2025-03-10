package Lezione2;


public class Main {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Quantity q1 = new Quantity(3);
        var q2 = new Quantity(4);
        /* nelle nuove versioni di Java, quando abbiamo a che fare con una variabile locale (allocata
         * sullo stack), posso scrivere var, ma solo nel corpo di un metodo e va inizializzato
         */

        int w = Quantity.MAX;

        //posso anche
        q1 = null;  //assegnabile a qualunque variabile di tipo NON-PRIMITIVO
        /* null è un area di memoria nell'HEAP */
        q1 = q2;


        Quantity q3 = new Quantity(4);

        boolean b1 = q1 == q2;  //true
        boolean b2 = q1 == q3;  //false
        //ricordiamo che l'== confronta i valori nello stack, in questo caso un puntatore

        boolean b3 = q1.equals(q2); //true
        boolean b4 = q1.equals(q3); //sempre false perché non avendo definito un equals, viene usato l'==




        int[] v = {1, 2, 3};
        /* in realtà dietro le quinte c'è una classe int[] avente come campi la lunghezza + gli elementi */
        //dunque facendo
        int l = v.length;   //sto accedendo direttamente alla variabile di istanza dell'oggetto v (è public)
        /* tuttavia facendo v.length = 4 NON posso farlo in quanto è una quantità FINAL */


        int[][] m = {
            {1, 2},
            {3, 4}
        };
        /* dietro le quinte viene formato un oggetto int[][] contenente due elementi di tipo int[] + la lunghezza,
         * che a sua volta contiene due int + la lunghezza
         * dunque in linea teorica potrei creare un array di array, anche di lunghezze differenti
         */


        /* dunque per realizzare una matrice in Java, il modo migliore è creare una classe Matrice */
    }
}
