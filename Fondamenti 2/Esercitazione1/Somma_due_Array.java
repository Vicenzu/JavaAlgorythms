import IO.*;

public class Somma_due_Array {
    
    public static int somma (int[]a1, int[]a2) {
        int res = 0;
        for (int i=0; i<a1.length; i++) {
            res += a1[i] + a2[i];
        }
        return res;
    }

    public static void main(String[] args) {
        
        int[] a = {2,3,4,5,6,7};
        int[] a1 = {5,9,5,2,6,4};
        IO.print(somma(a, a1));
    }
}
