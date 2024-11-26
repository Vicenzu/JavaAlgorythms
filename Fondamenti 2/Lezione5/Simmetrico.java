import IO.*;
public class Simmetrico {

    //Funzione che verifica se l'array è simmetrico
    public static boolean isSimmetrico(int[] a) {
        for (int i=0; i<a.length/2; i++) {
            if (a[i] != a[a.length-i-1])
                return false;
        }
        return true;
    }

    public static int[] inputArray() {
        int n = 0;
        while (n<=0)
            n = IO.readInt("Dammi la lunghezza: ");

        int[] a = new int[n];
        for (int i=0; i<n; i++)
            a[i] = IO.readInt("Dammi un numero intero: ");
        
        return a;
    }

    public static void main(String[] args) {
        
    IO.print(isSimmetrico(inputArray()));
   
    }
}