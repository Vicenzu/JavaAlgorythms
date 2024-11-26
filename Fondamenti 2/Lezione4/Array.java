import IO.*;

public class Array {
    public static void main(String[] args) {
        
        int n = 0;
        while (n<=0)
            n = IO.readInt("Dammi un valore valido per la lunghezza della sequenza: ");

        int[] a = new int[n];
        for (int i=0; i<n; i++)
            a[i] = IO.readInt("Dammi un numero intero: ");

        IO.println("Questa è la sequenza dei numeri digitati: ");
        for (int i=0; i<n; i++)
            IO.print(a[i]+"; ");

    }   
}