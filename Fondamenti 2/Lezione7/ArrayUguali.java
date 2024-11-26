import IO.*;
public class ArrayUguali {
    /*metodo che restituisce un booleano che verifica se due array sono uguali (come contenuto), prima
    assicurarsi che abbiano la stessa lunghezza*/
    public static boolean array_uguali (int[]a, int[]b) {
        
        if (a.length == b.length) 
            for (int i=0; i<a.length; i++) {
                if (a[i]!=b[i])
                    return false;
            }
        else
            return false;
        
        return true;    
    }

    //Metodo che prende due vettori di stringhe e verifica se sono uguali
    public static boolean array_uguali (String[]a, String[]b) {
        if (a.length == b.length) 
            for (int i=0; i<a.length; i++) {
                if (!a[i].equals(b[i]))
                    return false;
            }
        else
            return false;
        
        return true;   
    }

    public static void main(String[] args) {
        
        int[]a = {1,2,3,4,5};
        int[]b = {1,2,3,4,5};

        IO.println(array_uguali(a, b));

        String[] f = {"Mela", "Pera", "Banana"};
        String[] v = {"Mela", "Pera", "Banana", "Cocomero"};

        IO.println(array_uguali(f, v));
    }
}