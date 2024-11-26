import IO.*;

public class MediaArray {

    public static double media(int[] a) {
        int somma = 0;
        int count = 0;
        for (int i=0; i<a.length; i++) {
            somma += a[i];
            count++; 
        }
        return (double)(somma/count);
   }


    public static void main(String[] args) {
        
        int[] a = {3,4,5,6,7,2}; 
        IO.print(media(a));
    }
}
