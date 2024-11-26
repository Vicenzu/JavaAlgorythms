import IO.*;
public class CompareTo_Ricorsivo {
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
	
	public static void main(String[] args) {
		IO.println(compare_to("ciao", "bello"));
		IO.print(("ciao").compareTo("bello"));
	}
}