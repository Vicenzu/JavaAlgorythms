import IO.*;
public class Matrixes {
    
    //Riempiamo la matrice
    public static int[][] readMatrix(int[][]a) {
        for (int i=0; i<a.length; i++) {
            IO.println("Leggo la riga "+i);
            for (int j=0; j<a[0].length; j++) {
                a[i][j] = IO.readInt("Inserisci il valore da inserire nella riga "+i+ " e nella colonna " +j+": ");
            }
        }
        return a;
    }
    
    //Stampo la matrice
    public static void printMatrix (int[][]a) {
        for (int i=0; i<a.length; i++) {
            for (int j=0; j<a[0].length; j++) {
                IO.print (a[i][j] + " ");
            }
            IO.println();
        }
    }
    public static void main(String[] args) {
        //creo una matrice di 2 righe e 3 colonne
        int[][]m = new int[2][3];

        /*Negli array/matrici gli spazi vengono inizializzati a 0, (l'array sta nello stack che rimandano all'heap
        dove viene inizializzata; le variabili singole stanno nello stack ma se non vengono inizializzate non
        verranno rimandate all'heap) */
        //IO.print(m[0][0]);  // -> 0

        readMatrix(m);

        IO.println();
        IO.println("Adesso stampo la matrice: ");

        printMatrix(m);
    }
}
