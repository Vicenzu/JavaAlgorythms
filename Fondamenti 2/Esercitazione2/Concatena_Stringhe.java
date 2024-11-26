import IO.*;
public class Concatena_Stringhe {
    /*metodo che riceve un array di stringhe e restituisce una stringa che è la concatenazione di tutte le stringhe
     * dell'array in posizione dispari separate da uno spazio
     */
    public static String concatenaStringhe (String[] a) {
        String res = "";

        for (int i=1; i<a.length; i+=2) {
            res += a[i] + " ";
        }
        return res;
    }
    public static void main(String[] args) {
        String[] s = {"ciao", "come", "stai", "bene"};

        IO.print(concatenaStringhe(s));
    }
}
