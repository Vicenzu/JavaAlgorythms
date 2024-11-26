import IO.*;
public class aga {
    public static boolean verifica(String a, String b) {
        int p = 0;
        int cnt = 0;
        if (a.length() < b.length()) {
            p = a.length()/2;
            cnt = 0;
            
            for (int i=0; i<a.length(); i++) {
                if (a.charAt(i) == b.charAt(i))
                    cnt++;
            }
        }
        else {
            p = b.length()/2;
            cnt = 0;
            for (int i=0; i<b.length(); i++) {
                if (a.charAt(i) == b.charAt(i))
                    cnt++;
            }
        }

        if (cnt >= p)
            return true;
        else
            return false;
        
    }

    /*Due stringhe si dicono simili se esse coincidono in almeno p posizioni, dove p è la metà troncata della
    lunghezza della stringa più corta (es. abcdefabcdef e zbcaafacz sono simili perchè coincidono negli indici
    1,2,5,6 e p=4)
    Scrivere un metodo che riceva una matrice A di strinche e restituisca true se almeno una colonna di A contiene
    due stringhe simili*/
    public static boolean simili(String[][]mat) {
        for (int j=0; j<mat[0].length; j++) {
            for (int i=0; i<mat.length; i++) {
                String corrente = mat[i][j];
                for (int k=i+1; k<mat.length; k++) {
                    String successivo = mat[k][j];
                    if (verifica(corrente, successivo))
                        return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        String[][] m = {
            {"blla", "ckao", "cacca"},
            {"pistola", "ciola", "pipo"},
            {"kcla", "aziz", "porco"}
        };
        IO.print(simili(m));
    }
}