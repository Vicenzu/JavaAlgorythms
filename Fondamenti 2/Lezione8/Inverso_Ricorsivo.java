import IO.*;
public class Inverso_Ricorsivo {
    public static void inverso() {
        int n = IO.readInt("Quanti numeri devo leggere? ");
        int[] a = new int[n];

        for (int i=0; i<n; i++) {
            a[i] = IO.readInt("Digita il numero in posizione "+i+": ");
        }
        for (int i=n-1; i>=0; i--) {
            IO.print(a[i] + " ");
        }
    }

    public static void inverso_ric(int n) {
        if (n==1)
            IO.print(IO.readInt("Dimmi numero: ")+ " ");
        else {
            int x = IO.readInt("Digita numero: ");
            inverso_ric(n-1);
            IO.print(x + " ");
        }
    }

    public static void main(String[] args) {
        inverso_ric(IO.readInt("Digita quanti numeri: "));
    }
}

