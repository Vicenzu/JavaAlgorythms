import IO.*;
public class Sottosequenza_Ordinata_Ricorsiva {
    public static int compare_to(String a, String b) {
		return compare_to(a, b, 0);
	}
	//Metodo ricorsivo che fa la funzione .compareTo()
	public static int compare_to(String a, String b, int i) {
		if (i >= a.length() && i >= b.length()) //se l'indice raggiunge la fine di entrambe le stringhe allora sono uguali
			return 0;
		if (i >= a.length()) //se l'indice è maggiore della lunghezza di a allora vuol dire che a è più piccola di b
			return -1;
		if (i >= b.length()) //se l'indice è maggiore della lunghezza di b allroa sarà più piccola di a
			return 1;

		if (a.charAt(i) < b.charAt(i)) {
			return -1;
			}
		else if (a.charAt(i) > b.charAt(i)) { 
			return 1;
		}
		else {
			return compare_to(a, b, i+1);
		}
	}

    
    public static int sequenzaOrdinata(String[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }
        return sequenzaOrdinata(a, 0, 1, 1);
    }
    
    /*Metodo ricorsivo che prende in input un array di stringhe e restituisce la lunghezza della sottosequenza di 
    lunghezza massima ordinata in senso crescente. Le stringhe null vanno saltate */
    
    public static int sequenzaOrdinata (String[] a, int i, int maxAbs, int maxLocal) {
        if (i == a.length-1) {
            return maxAbs;
        }

        if (a[i] == null || a[i+1] == null || compare_to(a[i], a[i+1]) > 0) {
            return sequenzaOrdinata(a, i+1, maxAbs, 1);
        }

        //a[i] <= a[i+1]
        return sequenzaOrdinata(a, i+1, maxLocal+1 > maxAbs ? maxLocal+1 : maxAbs, maxLocal+1);
    }

    public static void main(String[] args) {
        String[] a = {"a", "b", "a", "e", "f", null, "c"};
        
        IO.println(sequenzaOrdinata(a));
    }
}