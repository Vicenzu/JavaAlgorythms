import IO.*;
public class Inverso_Array {
    //Funzione che fa l'array inverso
    public static int[] revert(int[]a) {
        int a_new[] = new int[a.length];

        for (int i=0; i<a.length; i++) {
            a_new[i] = a[a.length-i-1]; 
        }

        return a_new;
    }

    
    //invertendo la lista già presente
    public static void revert1 (int[]a) {
        int[] a_new = new int[a.length];

        for (int i=0; i<a.length; i++) {
            a_new[i] = a[a.length-i-1]; 
        }

        //inverto prima l'array d'appoggio e poi sostituisco quello di base
        for (int i=0; i<a.length; i++) {
            a[i] = a_new[i];
        }
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
        
        int[]a = {2,3,4,5};
        stampaArray(revert(a));
    }
}