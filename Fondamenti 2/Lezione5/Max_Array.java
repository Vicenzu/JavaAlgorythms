import IO.*;

public class Max_Array {
    //Funzione che prende in input un array e ne trova il massimo
    public static int massimo (int[] a) {
        //supponiamo di scrivere del codice che alla fine assegna alla variabile max il massimo dei valori di a
        int max = a[0];
        for (int i=1; i<a.length; i++) {
            if (a[i]>=max)
                max = a[i];
        }
        return max; //faccio la return perchè mi deve dare il valore max in output
    }

    public static void main(String[] args) {
        
        int n = 0;
        while (n<=0)
            n = IO.readInt("Dammi la lunghezza: ");

        int[] a = new int[n];
        for (int i=0; i<n; i++)
            a[i] = IO.readInt("Dammi un numero intero: ");

        IO.print(massimo(a));       

    }
}