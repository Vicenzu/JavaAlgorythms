import IO.*;

public class Esercizio5 {
    public static void main(String[] args) {
        //Popolare un vettore di interi da input e scrivere in output la sequenza inversa

        int n = 0;
        while (n <= 0)
            n = IO.readInt("Digita la lunghezza: ");
        
        int[] a = new int[n];
        for (int i = 0; i<a.length; i++)
            a[i] = IO.readInt("Digita valore: ");

        IO.println("Questa è la sequenza inversa: ");
        //faccio la sequenza inversa
        
        for (int i = a.length-1; i>=0; i--) {
            IO.println(a[i]+"; ");
        }
    }    
}