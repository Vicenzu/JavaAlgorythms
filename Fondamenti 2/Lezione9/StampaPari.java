import IO.*;
public class StampaPari {    
    //Metodo che prende in input un array di stringhe e fa la stampa di quelle in posizione pari
    public static void stampaPari(String[] a, int i) {
        if (i >= a.length)
            return;
        
        IO.println(a[i]);
        stampaPari(a, i+2);
    }

    public static void stampaPari (String[] a) {
        stampaPari(a, 0);
    }

    //variante che restituisce invece un array contenente le stringhe valide
    public static String[] estraiStringhePari (String[] a) {
        String[] res = new String[a.length%2 == 0? a.length/2:(a.length/2)+1];

        popolaArrayPari(a, res, 0);
        return res;
    }

    public static void popolaArrayPari(String[] a, String[] b, int i) {
        if (i >= a.length)
            return;
        
        b[i/2] = a[i];
        popolaArrayPari(a, b, i+2);
    }

    public static void main(String[] args) {
        String[]a = {"ciao", "come", "stai"};
        stampaPari(a);

        String[] b = estraiStringhePari(a);
        for (int i=0; i<b.length; i++)
            IO.println(b[i]);
    }
}
