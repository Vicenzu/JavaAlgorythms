import IO.*;
public class Massimo_indice {
    /*metodo che prende come argometo una matrice e restituisce l'indice di una riga che contiene il 
    valore massimo presente nella matrice.*/
    public static int Massimo_i(int[][] a) {
        int max = a[0][0];
        int i_max = 0;
        for (int i=0; i<a.length; i++) {
            for (int j=0; j<a[0].length; j++) {
                if (a[i][j] > max) {
                    max = a[i][j];
                    i_max = i;
                }
            }
        }
        return i_max;
    }

    public static void main(String[] args) {
        int [][] m = {
            {1,2,3,4,5},
            {13,564,75,68,12},
            {6,4,23,88,5},
            {4,7,8,23,45},
            {7,3,45,7,8}
        };

        IO.print(Massimo_i(m));
    }
}