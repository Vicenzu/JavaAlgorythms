import IO.*;
public class Max_Diagonale {
    /*Leggere una matrice da input (verificando sia quadrata) e restituire il valore massimo della diagonale*/
    public static int[][] readMatrix(int[][]a) {
        for (int i=0; i<a.length; i++) {
            IO.println("Leggo la riga "+i);
            for (int j=0; j<a[0].length; j++) {
                a[i][j] = IO.readInt("Inserisci il valore da inserire nella riga "+i+ " e nella colonna " +j+": ");
            }
        }
        return a;
    }

    public static void main(String[] args) {
        
        int righe = IO.readInt("Dimmi il numero di righe: ");
        int colonne = 0;
        while (colonne!=righe)   
            colonne = IO.readInt("Dimmi il numero di colonne: ");

        int [][]m = new int[righe][colonne];
        readMatrix(m);

        int massimo = m[0][0];
        for (int i=1; i<m.length; i++) {
            if (m[i][i] > massimo)
                massimo = m[i][i];
        }
    
        IO.print("Il massimo è: "+massimo);
    }
}