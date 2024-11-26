package Lezione16;
import java.util.*;

import listeconcatenate.*;
import IO.*;
public class a {
	//Metodo che verifica se una lista è palindroma
	public static boolean isPalindrome(LinkedList<Integer> l) {
		if (l == null || l.size() <= 1)
			return true;
		
		ListIterator<Integer> sx = l.listIterator();
		ListIterator<Integer> dx = l.listIterator(l.size()); //Se nel listIterator mettiamo tra parentesi un valore,
		// partirà da quel punto, in questo caso dato che deve partire dalla fine mettiamo l.size()
		while (sx.nextIndex()<dx.previousIndex()) { //Possiamo verificare gli indici con nextIndex() o previousIndex()
			if (sx.next() != dx.previous()) 				// (PRESENTI SOLO PER I LISTITERATOR)
				return false;
		}
		return true;
	}

	//Forma Ricorsiva
	public static boolean isPalindromeRic(LinkedList<Integer> l) {
		if (l == null || l.size() <= 1)
			return true;
		
		ListIterator<Integer> sx = l.listIterator();
		ListIterator<Integer> dx = l.listIterator(l.size());

		return isPalindromeRic(sx, dx);
	}
	private static boolean isPalindromeRic(ListIterator<Integer> sx, ListIterator<Integer> dx) {
		if (sx.nextIndex() >= dx.previousIndex())
			return true;
		
		if (!sx.next().equals(dx.previous()))
			return false;
			
		return isPalindromeRic(sx, dx);
	}

	//Metodo che verifica se una lista è inversa all'altra
	public static boolean isInverse(LinkedList<Integer> l, LinkedList<Integer> l1) {
		if (l.size() != l1.size())
			return false;
		if (l == null && l1 == null || l.size() <= 1 && l1.size()<= 1 && l.size()==l1.size())
			return true;

		Iterator<Integer> lsx = l.iterator();
		ListIterator<Integer> l1dx = l1.listIterator(l1.size());

		while (lsx.hasNext()) {
			if (!lsx.next().equals(l1dx.previous()))
				return false;
		}
		return true;
	}

	//Forma Ricorsiva
	public static boolean isInverseRic(LinkedList<Integer> l, LinkedList<Integer> l1) {
		if (l.size() != l1.size())
			return false;
		if (l == null || l1 == null || l.size() <= 1 && l1.size()<= 1 && l.size()==l1.size())
			return true;

		Iterator<Integer> lsx = l.iterator();
		ListIterator<Integer> l1dx = l1.listIterator(l1.size());

		return isInverseRic(lsx, l1dx);
	}
	public static boolean isInverseRic(Iterator<Integer> lsx, ListIterator<Integer> l1dx) {
		if (!lsx.hasNext())
			return true;
		
		if (!lsx.next().equals(l1dx.previous()))
			return false;

		return isInverseRic(lsx, l1dx);
	}


	public static void main(String[] args) {
		LinkedList<Integer> l = new LinkedList<>();
		l.addLast(6);
		l.addLast(5);
		l.addLast(4);
		l.addLast(3);
		l.addLast(2);
		l.addLast(1);

		LinkedList<Integer> l1 = new LinkedList<>();
		l1.addLast(1);
		l1.addLast(2);
		l1.addLast(3);
		l1.addLast(4);
		l1.addLast(5);
		l1.addLast(6);

		IO.println(l.size());
		IO.println(l1.size());

		IO.println(isInverseRic(l, l1));


		ListaConcatenataInt l0 = new ListaConcatenataInt(new int[] {1,2,3,4});
		IO.println(l0.stampaPrecedentePos(2));
	}
}
