import IO.*;
public class Array_StringPalindrome_Ricorsivo {
    //Metodo che verifica palindromo su vettore di stringhe (ricorsiva)
    public static boolean check(String[] a, int i) {
        if (i == a.length/2)
            return true;
        else {
            if (!a[i].equals(a[a.length-i-1]))
                return false;
            return check(a, i+1);
        }
    }

    public static boolean isPalindrome(String[] a) {
        return check(a, 0);
    }

    public static void main (String[] args) {
        String[] a = {"cane", "casa", "casa", "cane"};
        String[] b = {"cacca", "culo", "pisello"};

        IO.println(isPalindrome(a));
        IO.print(isPalindrome(b));
    }
}