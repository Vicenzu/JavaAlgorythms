import IO.*;

public class Media_n_Array {
    /*Funzione che restituisce la media dei valori presente nel vettore maggiore di x, se non ne esistono
    restituisce 0*/
    public static float media (int[] a, int x) {
        //prende in input un array e un intero
        float count = 0;
        int tot = 0;
        for (int i=0; i<a.length; i++) {
            if (a[i]>x) {
                count++;
                tot += a[i];
            }
        }
            
        float res = tot/count;
        if (res>=0 || res<=0)
            return res;
        else
            return 0;

    }


    public static void main(String[] args) {
        
        int n = 0;
        while (n<=0)
            n = IO.readInt("Dammi la lunghezza: ");

        int[] a = new int[n];
        for (int i=0; i<n; i++)
            a[i] = IO.readInt("Dammi un numero intero: ");

        int x = IO.readInt("Digita il valore: ");

        IO.print(media(a, x));

    }
}
