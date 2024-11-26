import IO.*;
public class Array_ordinato_Ricorsivo {
    //prof
    private static boolean eOrdinatoProf (int[] a, boolean crescente, int i) {
        if (i == a.length-1) 
            return true;
        if (crescente && a[i] > a[i+1]) 
            return false;
        if (!crescente && a[i] < a[i+1])
            return false;
        return eOrdinatoProf(a, crescente, i+1);
    }

    private static boolean eOrdinato (int[] a, boolean crescente, int i) {
        if (crescente) {
            if (a[i] > a[i+1])
                return false;
            return eOrdinato(a, crescente, i+1);
        }
        else { //decrescente
            if (i<a.length-1) {
                if (a[i] < a[i+1]) {
                    return true;
                }
                return eOrdinato(a, crescente, i+1);
            }
            else {
                return true;
            }
        }
    }

    public static boolean eOrdinato(int[] a, boolean crescente) {
        return eOrdinato(a, crescente, 0);
    }

    public static boolean eOrdinatoo(int[] a, boolean crescente) {
        return eOrdinatoProf(a, crescente, 0);
    }

    public static void main(String[] args) {
    int[]a = {1,2,3,4};
    IO.println(eOrdinato(a, false));
    }
}