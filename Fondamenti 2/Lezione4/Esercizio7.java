import IO.*;
public class Esercizio7 {
    public static void main(String[] args) {
        //Popolare un vettore da input e verificare se è simmetrico
        
        int n = 0;
        while (n <= 0) 
            n = IO.readInt("Digita la lunghezza: ");
        
        int[] a = new int[n];
        for (int i = 0; i<a.length; i++)
            a[i] = IO.readInt("Digita valore: ");

        IO.println("Eseguo la verifica della simmetricità");

        /*
        boolean simmetrico = true;
        
        // X Casa rifare questo for loop ma con il while, senza la variabile simmetrico, e con il break
        
        for (int i=0; i<a.length; i++) {
            if (a[i]!=a[a.length-1-i]) {
                simmetrico = false;
                break;
            }
        }
        if (simmetrico)
            IO.print("La sequenza è simmetrica");
        else
            IO.print("La sequenza non è simmetrica");
        */
        int i = 0;
        while (i<a.length) {
            if (a[i]!=a[a.length-1-i]) {
                IO.print("La sequenza non è simmetrica");
                    break;
                }
            i++;
            }
            IO.print("La sequenza è simmetrica");
    }
}
