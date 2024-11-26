import IO.*;
public class Esercizio6 {
    public static void main(String[] args) {
        /*Popolare un vettore da input e contare quanti elementi sono maggiori del predecessore o del successivo
        (o di entrambi) */

        int lunghezza = 0;
        while (lunghezza<=0)
            lunghezza = IO.readInt("Digita la lunghezza: ");

        int[] a = new int[lunghezza];
        for (int i = 0; i<lunghezza; i++)
            a[i] = IO.readInt("Digita valore: ");
        
        int count = 0;
        for (int i = 1; i<lunghezza-1; i++)
            if ((a[i-1]<a[i]) || (a[i+1]<a[i]))
                count++;

        IO.print(count);
    }
}