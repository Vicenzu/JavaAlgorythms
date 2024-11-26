import IO.*;
public class Array_palindomo_Ricorsivo {

    public static boolean isPalindromeArray (int[] a) {
        if (a.length == 1)
            return true;
        if (a.length == 2)
            return a[0] == a[1];
        if (a[0] != a[a.length-1])
            return false;

        int[] b = new int[a.length-2];
        for (int i=0; i<b.length; i++) {
            b[i] = a[i+1];
        }
        return isPalindromeArray(b);
    }


    public static boolean isPalindrome_ric(int[]a, int i) {
        if (i == a.length/2)    //dobbiamo stabilire quando si ferma la i (ovvero a metà array)
            return true;
        else {
            if (a[i] != a[a.length-i-1])
                return false;
            else
                return isPalindrome_ric(a, i+1); //facciamo la chiamata ricorsiva per aumentare l'indice
        }
    }


    public static boolean isPalindrome(int[] a) {
        return isPalindrome_ric(a, 0);
    }

    public static void main(String[] args) {
        int[]a = {1,2,4,5,6};
        int[]b = {1,2,3,2,1};
    
    IO.println(isPalindrome(a));
    IO.println(isPalindrome(b));
    }
}
