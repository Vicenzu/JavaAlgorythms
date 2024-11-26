import IO.*;
public class Array_i_max {
    /*metodo che prende come argomento una matrice e restituisce un vettore contenente gli indici delle 
    righe che contengono il valore massimo presente nella matrice*/
    
    public static int[] array_i (int[][] m) {
        int max = m[0][0];
        //calcolo il massimo della matrice
        for (int i=0; i<m.length; i++) {
            for (int j=0; j<m[0].length; j++) {
                if (m[i][j] > max) {
                    max = m[i][j];
                }
            }
        }

        //conto quante volte compare il massimo
        int cnt = 0;
        for (int i=0; i<m.length; i++) {
            for (int j=0; j<m[0].length; j++) {
                if (m[i][j] == max) {
                    cnt++;
                    break;
                }
            }
        }

        //Mi creo l'array (lunghezza cnt), dove metterò gli indici del massimo
        int i_array = 0;
        int[] a = new int[cnt];
        for (int s=0; s<m.length; s++) {
            for (int j=0; j<m[0].length; j++) {
                if (m[s][j] == max) {
                   a[i_array] = s;
                   i_array++;
                   break;
                }
            }
        }

        return a;
    }

    public static void stampaArray(int[] arraydastampare) {
        IO.print("[");
        for (int i = 0; i<arraydastampare.length; i++) {
            IO.print(arraydastampare[i]);
            if (i<arraydastampare.length-1)
                IO.print("; ");
        }
        IO.print("]");
    }


    public static void main(String[] args) {
        
        int[][] mat = {
            {1,2,34,5},
            {5,4,7,8},
            {7,8,2,34},
            {34,6,1,8}
        };

        stampaArray(array_i(mat));
        
    }
}