import IO.*;
public class ArrayMassimo {
    /*Funzione che prende in input 3 array di stessa dimensione (a b c) e ne crea uno nuovo contenente
    in ogni posizione i è contenuto il valore massimo tra a[i] b[i] c[i]*/
    public static int[] arrayMax (int[]a, int[]b, int[]c) {
        int[]d = new int[a.length];
        for (int i=0; i<a.length; i++) {
            int massimo = a[i];
            if (b[i] > massimo)
                massimo = b[i];
            
            if (c[i] > massimo)
                massimo = c[i];
            
            d[i] = massimo;
        }
        return d;
    }

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
        
        int[] a = {1,3,4};
        int[] b = {4,5,7};
        int[] c = {9,2,6};

        stampaArray((arrayMax(a, b, c)));
    }
}