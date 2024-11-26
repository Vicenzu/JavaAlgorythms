import IO.*;
public class Swap {
    
    public static void scambia(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }
    public static void main(String[] args) {
        int a = IO.readInt("Digita a: ");
        int b = IO.readInt("Digita b: ");

        IO.println("A: "+a+" B: "+b);

        scambia(a, b);

        IO.print("A: "+a+" B: "+b);
        /*Noteremo che non avverrà nessuno scambio, ma questo succede poichè lo scambio verrà effettuato dentro
         * il record di attivazione della funzione tra le variabili copiate, dunque una volta che la funzione
         * termina, il record viene cancellato
         * 
         * In generale, per quanto riguarda il passaggio degli argomenti all'interno dei metodi, verranno passati
         * in copia. Ma ciò non vale negli array, dato che punta sempre alle stesse celle dell'heap
         */
    }
}
