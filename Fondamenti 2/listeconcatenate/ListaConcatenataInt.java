package listeconcatenate;
import IO.*;
@SuppressWarnings("unused")

//creo la classe nodo. 
/*In un file non si possono definire due classi public, posso creare più classi in un file solo se non pubbliche
e sarà accessibile solo all'interno del package. In questo caso la classe nodo non sarà accessibile dall'esterno*/
class NodoInt {
	private NodoInt prec;
	private int info; //contenuto del nodo
	private NodoInt succ; //struttura ricorsiva dove una cella chiama un'altra cella
   
	public NodoInt () {
		this.prec = null;
		this.info = 0;
		this.succ = null;
	}

	public NodoInt(NodoInt prec, int info, NodoInt succ) {
		this.prec = prec;
		this.info = info;
		this.succ = succ;
	}

	public NodoInt getPrec() {
		return prec;
	}

	public void setPrec(NodoInt prec) {
		this.prec = prec;
	}

	public int getInfo() {
		return info;
	}

	public void setInfo(int info) {
		this.info = info;
	}

	public NodoInt getSucc() {
		return succ;
	}

	public void setSucc(NodoInt succ) {
		this.succ = succ;
	}

	public String toString() {
		return "" + this.info; //un modo di fare il typecasting è di concatenare una stringa vuota
	}
}

//CLASSE PRINCIPALE PUBBLICA
public class ListaConcatenataInt {
	private NodoInt testa;
	private NodoInt coda;
	private int lunghezza;

	public ListaConcatenataInt() {
		this.testa = null;
		this.coda = null;
		this.lunghezza = 0;
	}

	public ListaConcatenataInt(int[] a) {
		if (a == null || a.length == 0) {
			this.testa = null;
			this.coda = null;
			this.lunghezza = 0;
		}
		else {
			for (int i=0; i<a.length; i++) {
				this.aggiungiInCoda(a[i]);
			}
		}
	}

	//costruttore per copia - DEEP COPY
	public ListaConcatenataInt(ListaConcatenataInt l_old) {
		if (l_old == null || l_old.lunghezza == 0) {
			this.testa = null;
			this.coda = null;
			this.lunghezza = 0;
		}
		for (NodoInt it=l_old.testa; it!=null; it=it.getSucc()) {
			this.aggiungiInCoda(it.getInfo());
		}
	}
		
	public String toString() {
		String s = "[";
		for (NodoInt it=this.testa; it!=null; it=it.getSucc()) {
			if (it.getSucc() != null)
				s += it + ", ";
			else //in questi casi possiamo concatenare direttamente it perchè dato che abbiamo 
				s += it; //concatenato una stringa, avremo fatto un typecasting e quindi richiamerà in automatico il metodo toString
		}

		return s + "]";
	}

	public NodoInt getTesta() {
		return testa;
	}

	public void setTesta(NodoInt testa) {
		this.testa = testa;
	}

	public NodoInt getCoda() {
		return coda;
	}

	public void setCoda(NodoInt coda) {
		this.coda = coda;
	}

	public int getLunghezza() {
		return lunghezza;
	}

	public void setLunghezza(int lunghezza) {
		this.lunghezza = lunghezza;
	}


	//Metodo che aggiunge un elemento all'inizio
	/*Astrattamente, andiamo a creare un nodo che va a puntare alla vecchia testa, e aumentiamo la lunghezza.
	Nel caso di una lista vuota, quando andiamo ad aggiungere un elemento, dovremo aggiornare sia la testa,
	sia la lunghezza, sia la CODA(perchè la nuova testa sarà anche la nuova coda) */
	public void aggiungiInTesta(int info) {
		NodoInt nuovaTesta = new NodoInt(null, info, this.testa); //creiamo il nuovo nodo da aggiungere in testa
		
		this.testa = nuovaTesta; //aggiorniamo l'indirizzo della vecchia testa
		
		if (this.lunghezza == 0) //se la lista ha un solo elemento allora la coda sarà uguale alla nuova testa
			this.coda = nuovaTesta;
		else { 
			this.testa.setPrec(nuovaTesta);
		}

		this.lunghezza++; //infine aggiorno la lunghezza
	}

	public void aggiungiInCoda(int info) {
		NodoInt nuovaCoda = new NodoInt(this.coda ,info, null); //essendo l'ultimo della lista, come succ avrà null
		
		if (this.lunghezza == 0) {
			this.testa = nuovaCoda;
		}
		else {
			this.coda.setSucc(nuovaCoda); //Aggiorniamo il successore della vecchia coda
		}
		this.coda = nuovaCoda; //Aggiorniamo la variabile coda

		this.lunghezza++;
	}
	
	//Metodo che elimina la testa della lista corrente, se la lista è vuota restituisce false, altrimenti true
	public boolean rimuoviTesta() {
		if (this.lunghezza == 0)
			return false;
		
		this.testa = this.testa.getSucc();
		this.testa.setPrec(null);

		if (this.lunghezza ==1) 
			this.coda = null;
		
		lunghezza --;

		return true;
	}
	
	public boolean rimuoviCoda() {
		if (this.lunghezza == 0)
			return false;

		else if (this.lunghezza == 1) {
			this.testa = null;
			this.coda = null;
		}
		else {
			for (NodoInt it=this.testa; it!=null; it=it.getSucc()) {
				if (it.getSucc() == this.coda) { //Se il successivo del nodo corrente è la coda
					it.setSucc(null);	//Allora setto il succ a null
					this.coda = it;	//Reimposto la nuova coda
				}
			}
		}
		this.lunghezza--;
		return true;
	}
	
	//Metodo booleano che aggiunge un elemento in una specifica posizione
	public boolean aggiungiInPosizione(int info, int pos) {
		//restituisce falso se il valore di pos non è valido (pos < 0 o pos > lunghezza)
		if (pos < 0 || pos > this.lunghezza)
			return false;
		if (pos == 0) {
			this.aggiungiInTesta(info);
			return true;
		}
		if (pos == this.lunghezza) {
			this.aggiungiInCoda(info);
			return true;
		}

		int i = 1;
		NodoInt it = this.testa;
		while (i < pos) {
			i++;
			it = it.getSucc();
		}

		NodoInt nuovoNodo = new NodoInt(it, info, it.getSucc());
		it.setSucc(nuovoNodo);
		it.getSucc();
		it.getSucc();
		it.setPrec(nuovoNodo);
		this.lunghezza ++;
		return true;
	}

	public boolean modificaInPosizione(int info, int pos) {
		if (pos < 0 || pos >= this.lunghezza)
			return false;
		if (this.lunghezza == 0)
			return false;
		else {
			int count = 0;
			for (NodoInt it=this.testa; it!=null; it=it.getSucc()) {
				if (count == pos) {
					it.setInfo(info);
				}
				else 
					count++;
			}
			return true;
		}
	}

	public boolean rimuoviInPosizione(int pos) {
		if (pos < 0 || pos >= this.lunghezza)
			return false;
		if (this.lunghezza == 0)
			return false;
		if (pos == 0)
			this.rimuoviTesta();
		if (pos == this.lunghezza-1)
			this.rimuoviCoda();
		
		int count = 1;
		for (NodoInt it=this.testa; it!=null; it=it.getSucc()) {
			if (count == pos) {	//se il prossimo è il nodo da rimuovere
				it.setSucc((it.getSucc()).getSucc()); //Settiamo il succ del corrente con il succ del nodo da rimuovere
				it.getSucc().setPrec(it);
				this.lunghezza--;
			}
			else
				count++;
		}
		return true;
	}

	public int sommaDinamica() {
		int somma = 0;
		for (NodoInt it=this.testa; it!=null; it=it.getSucc()) {
			somma += it.getInfo();
		}
		return somma;
	}

	//Metodo ricorsivo di somma
	public int sommaDinamicaRic() {
		return calcolo(this.testa);
	}
	private static int calcolo(NodoInt n) {
		if (n == null) 
			return 0;
		return n.getInfo() + calcolo(n.getSucc());
	}

	public int somma() {
		if (this.testa == null)
			return 0;
			
		int vecchiaTesta = this.testa.getInfo(); //mi salvo la vecchia testa
		this.rimuoviTesta(); //rimuovo la testa
		int sommaParteRestante = this.somma(); //totale
		this.aggiungiInTesta(vecchiaTesta); //aggiungo in testa alla fine la vecchiatesta
		return vecchiaTesta + sommaParteRestante; //restituisco il risultato della vecchiatesta più il totale
	}

	
	public boolean crescente()  {
		if (this.lunghezza == 0) //Non serve mettere il controllo (this.lunghezza <= 1) poichè viene fatta 
			return true; //direttamente dal for (it.getSucc()!=null)
		else {
			for (NodoInt it=this.testa; it.getSucc()!=null; it=it.getSucc())
				if (it.getInfo() > it.getSucc().getInfo())
					return false;
		}
		return true;
	}

	//Metodo ricorsivo
	public boolean crescenteRic() {
		return crescenteRic(this.testa);
	}
	private static boolean crescenteRic(NodoInt n) {
		if (n == null || n.getSucc() == null)
			return true;
		
		if (n.getInfo() > n.getSucc().getInfo())
			return false;

		return crescenteRic(n.getSucc());
	}


	public ListaConcatenataInt sottoSequenzaPari() {
		ListaConcatenataInt l = new ListaConcatenataInt();
		for (NodoInt it=this.testa; it!=null; it=it.getSucc()) {
			if (it.getInfo() % 2 == 0) 
				l.aggiungiInCoda(it.getInfo());
		}
		return l;
	}

	//Metodo ricorsivo
	public ListaConcatenataInt sottoSequenzaPariRic () {
		ListaConcatenataInt l = new ListaConcatenataInt();
		return sottoSequenzaPariRic(this.testa, l);
	}
	private ListaConcatenataInt sottoSequenzaPariRic (NodoInt n, ListaConcatenataInt l) {
		if (n == null)
			return l;
		else if (n.getInfo() % 2 == 0) 
			l.aggiungiInCoda(n.getInfo());
			
		return sottoSequenzaPariRic(n.getSucc(), l);
	}


	public void modifica() {
		if (this.testa == null || this.testa.getSucc() == null)
			return;

		int count = 1;
		for (NodoInt it=this.testa; it.getSucc()!=null; it=it.getSucc()) {
			if (it.getInfo() == it.getSucc().getInfo() && it.getInfo() != 0 && it.getSucc().getInfo() != 0) {
				aggiungiInPosizione(0, count);
			}
			count ++;
		}
	}

	//metodo ricorsivo
	public void modificaRic() {
		modificaRic(this.testa, this, 0);
	}
	private void modificaRic(NodoInt n, ListaConcatenataInt l, int count) {
		if(n.getSucc() == null)
			return;
			
		count++;
			if (n.getInfo() == n.getSucc().getInfo() && n.getInfo() != 0 && n.getSucc().getInfo() != 0) {
				l.aggiungiInPosizione(0, count);
			}
		
		modificaRic(n.getSucc(), l, count);
	}

	//Questi metodi ci permettono di prendere gli elementi dei nodi nel caso in cui ci servissero per altri metodi
	// nel main
	public int getInfoTesta() {
		return this.testa.getInfo();
	}

	public int getInfoCoda() {
		return this.coda.getInfo();
	}

	//Questo metodo è molto lento se usato fuori dalla classe perchè ogni volta che faremo un'iterazione per cercare
	// l'elemento i-esimo, questo metodo riscorrerà ogni volta la lista partendo dalla testa
	public int getInfoAt(int pos) {
		if (pos < this.lunghezza || pos > this.lunghezza)
			throw new RuntimeException("La posizione non è valida!");
		
		NodoInt it = this.testa;
		for (int i=0; i<pos; i++) {
			it=it.getSucc();
		}
		return it.getInfo();
	}
	
	public boolean equals(ListaConcatenataInt a) {
		if (this == a)
			return true;

		if (a == null || this.lunghezza != a.lunghezza)
			return false;
		
		NodoInt it = this.testa;
		NodoInt at = a.testa;
		for (int i=0; i<this.lunghezza; i++) {
			if (it.getInfo() != at.getInfo())
				return false;
			it=it.getSucc();
			at=at.getSucc();	
		}
	return true;
	}

	//metodo che verifica che ogni elemento di this, sia più grande di ogni elemento di l1 e più piccolo di ogni el di l2
	public boolean verifica(ListaConcatenataInt l1, ListaConcatenataInt l2) {
		return verifica(this.testa, l1, l2);
	}
	private boolean verifica(NodoInt n, ListaConcatenataInt l1, ListaConcatenataInt l2) {
		if (n == null)
			return false;
		if (n.getInfo() > max(l1) && n.getInfo() < min(l2))
			return true;
			
		return false;
	}

	public static int max(ListaConcatenataInt l) {
		if (l == null || l.lunghezza == 0)
			throw new RuntimeException("Lista non valida");
		
		int massimo = l.testa.getInfo();
	
		if (l.lunghezza == 1)
			return massimo; 
	
		for (NodoInt it=l.testa; it!=null; it=it.getSucc()) {
			if (it.getInfo() > massimo)
				massimo = it.getInfo();
		}
		return massimo;
	}

	public static int min(ListaConcatenataInt l) {
		if (l == null || l.lunghezza == 0)
			throw new RuntimeException("Lista non valida");
		
		int minimo = l.testa.getInfo();
	
		if (l.lunghezza == 1)
			return minimo; 
	
		for (NodoInt it=l.testa; it!=null; it=it.getSucc()) {
			if (it.getInfo() < minimo)
				minimo = it.getInfo();
		}
		return minimo;
	}
	
	public int stampaPrecedentePos(int pos) {
		NodoInt it = this.testa;
		int i = 0;
		int suca = 0;
		while (it != null) {
			if (i == pos)
				suca = it.getPrec().getInfo();
			it=it.getSucc();
			i++;
		}
		return suca;
	}

	//Esercizio 2 Prova 23 01 2023
	public int contaCoppie(int k) {
		return contaCoppie(this.testa, k, 0);
	}
	private static int contaCoppie(NodoInt n, int k, int count) {
		if (n.getSucc() == null)
			return count;
		if (n.getInfo() < k && n.getSucc().getInfo() >= k) {
			count++;
			n = n.getSucc();
			return contaCoppie(n, k, count);
		}
		n = n.getSucc();
		return contaCoppie(n, k, count);
	}

	/**
	 * Metodo ricorsivo che verifica se le somme dei numeri pari e dispari sono uguali
	 * @return
	 */
	public boolean sommeUguali() {
		return (sommeUguali(this.testa, 0, 0));
	}
	private boolean sommeUguali(NodoInt n, int totPari, int totDispari) {
		if (n == null)
			return totPari == totDispari;

		if (n.getInfo()%2 == 0)
			totPari += n.getInfo();
		else
			totDispari += n.getInfo();
	
		return sommeUguali(n.getSucc(), totPari, totDispari);
		}

	/**
	 * Esercizio 2 prova 15/02/2023
	 * @return Se l'elemento i-esimo + (i-1) è uguale a (i + i+1)/2 da true, sennò false
	 */	
	public boolean verificaCoppie() {
		if (this.lunghezza < 3)
			return false;
		return verificaCoppie(this.testa);
	}
	private boolean verificaCoppie(NodoInt n) {
		if (n.getSucc().getSucc() == null)
			return true;
		
		int prec = n.getInfo();
		int curr = n.getSucc().getInfo();
		int succ = n.getSucc().getSucc().getInfo();
		if (curr+prec != (curr+succ)/2f)
			return false;
		return (verificaCoppie(n.getSucc()));
	}

	//Ogni elemento deve essere maggiore della media degli elementi precedenti
	public boolean elementiMaggioriMediaPrec() {
		if (this.lunghezza <= 1)
			return true;
		return elementiMaggioriMediaPrec(this.testa.getSucc(), 1, this.testa.getInfo());
	}
	private boolean elementiMaggioriMediaPrec(NodoInt n, int i, int tot) {
		if (n == null)
			return true;
		
		if (n.getInfo() <= tot/(float)i)
			return false;
		
		return elementiMaggioriMediaPrec(n.getSucc(), ++i, tot+n.getInfo());
	}

	//Esercizio2 traccia 16 02 2023
	public boolean verifica(int lungMin, int n) {
		if (this.lunghezza <= lungMin)
			return false;

		if (this.testa.getInfo() < n)
			return verifica(this.testa.getSucc(), lungMin, n, 1, 0);
		if (this.testa.getInfo() == n)
			return false;
		return verifica(this.testa, lungMin, n, 0, 1);
		
	}
	private boolean verifica(NodoInt curr, int lungMin, int n, int lungSequenzaMinori, int lungSequenzaMaggiori) {
		if (curr.getSucc() == null)
			return true;

		if (curr.getInfo() > n) {
			if (curr.getSucc().getInfo() < n && lungSequenzaMaggiori <= lungMin) {
				return false;
			}
			return verifica(curr.getSucc(), lungMin, n, 0, ++lungSequenzaMaggiori);
		}
		else if (curr.getInfo() < n) {
			if (curr.getSucc().getInfo() > n && lungSequenzaMinori <= lungMin)
				return false;
			return verifica(curr.getSucc(), lungMin, n, ++lungSequenzaMinori, 0);
		}
		return false;
	}

	//Esercizio 2 Traccia 28 giugno 2023
	public boolean verificaPariDispari() {
		if (this.testa == null)
			return false;
		return verificaPariDispari(this.testa.getSucc(), this.testa.getInfo(), false);
	}
	private boolean verificaPariDispari(NodoInt n, int prec, boolean duepari) {
		if (n == null)
			return false;

		if (!duepari && n.getInfo()%2 == 0 && prec == n.getInfo())
			return verificaPariDispari(n.getSucc(), n.getInfo(), true);
		
		if (duepari && n.getInfo()%2 != 0)
			return true;

		if (duepari) {
			if (n.getInfo() == prec)
				return verificaPariDispari(n.getSucc(), n.getInfo(), true);
			return verificaPariDispari(n.getSucc(), n.getInfo(), false);
		}
		//if (!duepari && n.getInfo()%2 != 0 || n.getInfo() != prec)
		return verificaPariDispari(n.getSucc(), n.getInfo(), false);	
		
	}
	
	//Esercizio 2 Traccia 29 gennaio 2024
	public boolean verificaSomme(int k) {
		return verificaSomme(k, 0, this.testa);
		
	}
	private boolean verificaSomme(int k, int tot, NodoInt curr) {
		if (curr == null)
			return tot == 0 || tot == k;

		int currValue = curr.getInfo();

		if (currValue != 0) {
			return verificaSomme(k, tot+currValue, curr.getSucc());
		}
		else {
			if (tot != k)
				return false;
			return verificaSomme(k, 0, curr.getSucc());
		}
	}

	//Traccia 15 Settembre 2023
	public int contaTerne() {
		if (this.lunghezza < 3)
			return 0;
		if (this.lunghezza == 3) {
			if (this.testa.getSucc().getInfo() == this.testa.getInfo() + this.coda.getInfo())
				return 1;
			return 0;
		}
		return contaTerne(this.testa, 0);
	}
	private int contaTerne(NodoInt n, int cnt) {
		if (n.getSucc().getSucc() == null)
			return cnt;

		if (n.getSucc().getInfo() == n.getInfo() + n.getSucc().getSucc().getInfo())
			return contaTerne(n.getSucc(), ++cnt);
		return contaTerne(n.getSucc(), cnt);
	}

	public int contaTriple() {
		return contaTripleRic(this.testa, 0);
	}
	private int contaTripleRic(NodoInt n, int i) {
		if (n.getSucc().getSucc()==null)
			return i;
		if(n.getInfo()<0 && n.getSucc().getInfo()==0 && n.getSucc().getSucc().getInfo()>0)
			i++;
		return contaTripleRic(n.getSucc(), i);
	}
	
	


	public static void main(String[] args) {
		ListaConcatenataInt l = new ListaConcatenataInt(new int[] {5, -1, 0, 2, -2, -4, 0, 1, -2, -3, 0, -3, 0, -3, 0});
		IO.println(l.contaTriple());

	}
}