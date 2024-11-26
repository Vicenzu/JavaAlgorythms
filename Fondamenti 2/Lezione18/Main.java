package Lezione18;
import IO.*;
import java.util.*;
@SuppressWarnings("unused")
public class Main {
	
	public static boolean elementiMaggioriMediaPrec(LinkedList<Integer> l) {
		if (l == null || l.size() <= 1)
			return true;

		Iterator<Integer> it = l.iterator();
		return elementiMaggioriMediaPrec(it, 1, it.next());
	}
	private static boolean elementiMaggioriMediaPrec(Iterator<Integer> it, int i, int tot) {
		if (!it.hasNext())
			return true;
		
		int curr = it.next();
		if (curr <= tot/(float)i)
			return false;

		return elementiMaggioriMediaPrec(it, ++i, tot+curr);
	}

	public static void removeOdd(LinkedList<Integer> l) {
		if (l == null)
			return;
		if (l.size() == 1 && l.getFirst()%2 == 0)
			return;
		
		Iterator<Integer> it = l.iterator();
		removeOdd(it);
	}    
	private static void removeOdd(Iterator<Integer> it) {
		if (!it.hasNext())
			return;
		
		int curr = it.next();
		if (curr%2 != 0)
			it.remove();
		removeOdd(it);
	}

	public static void reverse(LinkedList<Integer> l) {
		if (l == null || l.size() <= 1)
			return;
		Iterator<Integer> it = l.iterator();
		reverse(l, it, 0, l.size());
	}
	private static void reverse(LinkedList<Integer> l, Iterator<Integer> it, int i, int length) {
		if (i < length)
			return;
		
	}

	public static void main(String[] args) {
		LinkedList<Integer> l = new LinkedList<>();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(5);
		l.add(6);
		l.add(7);
		l.add(8);
		l.add(9);
		l.add(10);

		Main.reverse(l);
		IO.println(l);

	}
}
