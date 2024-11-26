import IO.*;

public class Somma_Array {

    public static int somma(int[] a) {
        int somma = 0;
        for (int i=0; i<a.length; i++) {
            somma += a[i];
        }
        return somma;
    }
    
    public static void main(String[] args) {
        
        int[] array = {1, 2, 3, 4, 5};
        
        IO.print(somma(array));
    }
}
