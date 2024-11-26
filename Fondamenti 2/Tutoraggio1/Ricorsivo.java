package Tutoraggio1;
import IO.*;
public class Ricorsivo {
	//Metodo ricorsivo che dato un numero positivo x controlla se x è primo
	public static boolean primo(int x) {
		return x==1?false:primo(x, 2);
	}
	public static boolean primo(int x, int i) {
		if (i> x/2)
			return true;
		if (x%i == 0)
			return false; 
		return primo(x, i+=1);
	}

	/*Metodo che fa la divisione intera di x e y senza usare l'operatore /. ma usando solo operazioni di somma, 
	* sottrazione e gli operatori razionali*/
	public static int divisioneRic(int x, int y) {
		if (y == 0)
			throw new RuntimeException("Divisione per 0 non valida");
		if (x-y < 0)
			return 0;

		return 1 + divisioneRic(x-y, y);
	}
	
	public static int sommaIntervallo(int x, int y) {		
		if (x == y)
			return x;

		return x + sommaIntervallo(x+1, y);
	}

	//Metodo che trova il massimo comun divisore
	public static int MCD(int x, int y) {
		if (x%y == 0)
			return y;
		return MCD(y, x%y);
	}

	//Metodo che calcola la sommatoria con i che va da 2 a n - (x+i)/(2*i-1)
	//x > 0, n >= 2
	public static int sommatoria (int x, int n) {
		return sommatoria(x, n, 2);
	}
	public static int sommatoria(int x, int n, int i) {
		int term = (x+i)/(2*i-1); 
		if (i == n)
			return term;
			
		return term + sommatoria(x, n, i+=1);
	}

	public static void main(String[] args) {
		
		IO.println(primo(1));
		IO.println(divisioneRic(9, 3));
		IO.println(sommaIntervallo(0, 5));

		IO.println(MCD(3, 12));

		IO.println(sommatoria(1, 5));
	}
}
