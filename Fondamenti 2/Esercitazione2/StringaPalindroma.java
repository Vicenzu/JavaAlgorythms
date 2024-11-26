import IO.*;
public class StringaPalindroma {

    //metodo che verifica se una stringa è palindroma
    public static boolean isPalindrome (String a) {
        for (int i=0; i<a.length()/2; i++) {
            if ((a.charAt(i)) != (a.charAt(a.length()-i-1))) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        IO.print(isPalindrome("CioiC"));
    }
}