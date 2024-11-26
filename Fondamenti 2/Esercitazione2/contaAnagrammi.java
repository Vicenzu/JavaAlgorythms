import IO.*;
public class contaAnagrammi {
    public static int occorenze(char a, String b) {
        int cnt = 0;
        for (int i=0; i<b.length(); i++) {
            if (a == b.charAt(i))
                cnt++;
        }
        return cnt;
    }
    
    /*Metodo che riceve in input una stringa S ed un array A di stringhe e restituisce un numero che indica
    quante stringhe presenti nell'array a sono un anagramma della stringa S*/ 
    public static int analgrammaCounter(String S, String[]a) {
        int cnt = 0;
        
        for (int i=0; i<a.length; i++) {
            
            int j=0;
            boolean ok = true;
            while (ok && j<a[i].length()) {
                if (occorenze(S.charAt(j), S) != occorenze(S.charAt(j), a[i])) {
                    ok = false;
                }
                j++;
            }
            
            if (ok)
                cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {

        String S = "culo";
        String[] a = {"cane", "uloc", "locu"};
        IO.print(analgrammaCounter(S, a));
    }
}
