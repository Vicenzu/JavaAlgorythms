import IO.*;
public class El_in_Array {
    //verifica se l'elemento è contenuto nell'array
    public static boolean inArray(int[]a, int x) {
        for (int i=0; i<a.length; i++) {
            if (a[i] == x)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int x = 5;
        int[]a = {4,6,2,6,7,1,6};

        IO.print(inArray(a, x));
    }
}
