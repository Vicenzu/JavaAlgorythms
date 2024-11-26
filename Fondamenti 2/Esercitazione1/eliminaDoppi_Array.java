import IO.*;

public class eliminaDoppi_Array {
    public static boolean contains(int[]a, int x) {
        for (int i=0; i<a.length; i++) {
            if (a[i] == x)
                return true;
        }
        return false;
    }
    
    /*Funzione che riceve in input un array di interi (compresi tra 0 e 9), restituisce un nuovo array contenente
    tutti gli interi di a non ripetuti*/
    public static int[] eliminaDoppi (int[]a) {
        int[] b = new int[a.length];
        int j = 0;
        for (int i=0; i<a.length; i++) {
            if (!contains(b, a[i])) {
                b[j] = a[i];
                j++;
            }    
        }
        /*ma adesso ho l'array b contenente degli 0 alla fine e la lunghezza pari ad a, quindi siccome in
        j ho l'informazione di quanti elementi ho in b*/

        int[] c = new int[j];
        for (int i=0; i<j; i++) {
            c[i] = b[i];
        }

        return c;
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
        
        int[] a = {3,2,2,3,9};
        stampaArray(eliminaDoppi(a));

    }
}