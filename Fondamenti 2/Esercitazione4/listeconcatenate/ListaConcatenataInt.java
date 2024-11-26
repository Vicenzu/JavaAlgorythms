package Esercitazione4.listeconcatenate;
//creo la classe nodo. 
/*In un file non si possono definire due classi public, posso creare più classi in un file solo se non pubbliche
e sarà accessibile solo all'interno del package. In questo caso la classe nodo non sarà accessibile dall'esterno*/
class Nodo {
	private int info; //contenuto del nodo
	private Nodo succ; //struttura ricorsiva dove una cella chiama un'altra cella
   
	public Nodo () {
		this.info = 0;
		this.succ = null;
	}

	public Nodo(int info, Nodo succ) {
		this.info = info;
		this.succ = succ;
	}

	public int getInfo() {
		return info;
	}

	public void setInfo(int info) {
		this.info = info;
	}

	public Nodo getSucc() {
		return succ;
	}

	public void setSucc(Nodo succ) {
		this.succ = succ;
	}

	public String toString() {
		return "" + this.info; //un modo di fare il typecasting è di concatenare una stringa vuota
	}
}

//CLASSE PRINCIPALE PUBBLICA
public class ListaConcatenataInt {
	private Nodo testa;
	private Nodo coda;
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
		
	public String toString() {
		String s = "[";
		for (Nodo it=this.testa; it!=null; it=it.getSucc()) {
			if (it.getSucc() != null)
				s += it + ", ";
			else //in questi casi possiamo concatenare direttamente it perchè dato che abbiamo 
				s += it; //concatenato una stringa, avremo fatto un typecasting e quindi richiamerà in automatico il metodo toString
		}

		return s + "]";
	}

	public Nodo getTesta() {
		return testa;
	}

	public void setTesta(Nodo testa) {
		this.testa = testa;
	}

	public Nodo getCoda() {
		return coda;
	}

	public void setCoda(Nodo coda) {
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
		Nodo nuovaTesta = new Nodo(info, this.testa); //creiamo il nuovo nodo da aggiungere in testa
		
		this.testa = nuovaTesta; //aggiorniamo l'indirizzo della vecchia testa
		if (this.lunghezza == 0) //se la lista ha un solo elemento allora la coda sarà uguale alla nuova testa
			this.coda = nuovaTesta;
		
		this.lunghezza++; //infine aggiorno la lunghezza
	}

	public void aggiungiInCoda(int info) {
		Nodo nuovaCoda = new Nodo(info, null); //essendo l'ultimo della lista, come succ avrà null
		
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

		if (this.lunghezza ==1) 
			this.coda = null;
		
		lunghezza --;

		return true;
	}
	
	public void rimuoviCoda() {
		if (this.lunghezza == 0)
			throw new RuntimeException("Non è possibile rimuovere la coda");

		else if (this.lunghezza == 1) {
			this.testa = null;
			this.coda = null;
		}
		else {
			for (Nodo it=this.testa; it!=null; it=it.getSucc()) {
				if (it.getSucc() == this.coda) { //Se il successivo del nodo corrente è la coda
					it.setSucc(null);	//Allora setto il succ a null
					this.coda = it;	//Reimposto la nuova coda
				}
			}
		}
		this.lunghezza--;
	}
	
	//Metodo booleano che aggiunge un elemento in una specifica posizione
	public void aggiungiInPosizione(int info, int pos) {
		//restituisce falso se il valore di pos non è valido (pos < 0 o pos > lunghezza)
		if (pos < 0 || pos > this.lunghezza)
			throw new RuntimeException("Posizione non valida");
		if (pos == 0) {
			this.aggiungiInTesta(info);
		}
		if (pos == this.lunghezza) {
			this.aggiungiInCoda(info);
		}

		int i = 1;
		Nodo it = this.testa;
		while (i < pos) {
			i++;
			it = it.getSucc();
		}

		Nodo nuovoNodo = new Nodo(info, it.getSucc());
		it.setSucc(nuovoNodo);
		this.lunghezza ++;
	}

	public void modificaInPosizione(int info, int pos) {
		if (pos < 0 || pos >= this.lunghezza)
			throw new EccezioneIndiceNonValido();
		if (this.lunghezza == 0)
			throw new EccezioneIndiceNonValido();
		else {
			int count = 0;
			for (Nodo it=this.testa; it!=null; it=it.getSucc()) {
				if (count == pos) {
					it.setInfo(info);
				}
				else 
					count++;
			}
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
		for (Nodo it=this.testa; it!=null; it=it.getSucc()) {
			if (count == pos) {	//se il prossimo è il nodo da rimuovere
				it.setSucc((it.getSucc()).getSucc()); //Settiamo il succ del corrente con il succ del nodo da rimuovere
				this.lunghezza--;
			}
			else
				count++;
		}
		return true;
	}

	public int get(int pos) {
		if (pos < 0 || pos >= this.lunghezza)
			throw new EccezioneIndiceNonValido();

		Nodo n = this.testa;
		for (int i=0; i!= pos; i++) {
			n = n.getSucc();
		}
		return n.getInfo();
	}

	public String StampaElementiInPosizionePari() {
		String s = "[";

		int i = 0;
		for (Nodo it=this.testa; it!=null; it=it.getSucc()) {
			if (i%2 == 0) {
				s += it+" ";
			}
			i++;
		}
		s += "]";
		return s;
	}

	public int[] restituisciArray () {
		int[] res = new int[this.lunghezza];

		int i = 0;
		for (Nodo it=this.testa; it!=null; it=it.getSucc()) {
			res[i] = it.getInfo();
			i++; 
		}
		return res;
	}

	/*Restituisce una lista contenente solo i numeri maggiori di almeno uno tra prec e succ*/
	public static ListaConcatenataInt listaNumeriMaggiori(ListaConcatenataInt l) {
		ListaConcatenataInt res = new ListaConcatenataInt();
		Nodo prec = null;
		Nodo curr = l.testa;

		if (l.lunghezza == 0 || l.lunghezza == 1)
			return res;


		while (curr != null) {
			if (prec == null) {
				if (curr.getInfo() > curr.getSucc().getInfo()) //testa
					res.aggiungiInCoda(curr.getInfo());
			}
			else if (curr.getSucc() == null && curr.getInfo() > prec.getInfo()) //coda
				res.aggiungiInCoda(curr.getInfo());
			else {
				if (curr.getInfo() > prec.getInfo() || curr.getInfo() > curr.getSucc().getInfo()) {
					res.aggiungiInCoda(curr.getInfo());
				}
			}

			prec = curr;
			curr = curr.getSucc();
		}
		return res;
	}

	//esercizio ricorsivo - calcolare la lunghezza di una lista
	public static int lunghezzaRicorsiva(ListaConcatenataInt l) {
		if (l.testa == null)
			return 0;
		
		return calcolaLunghezzaR(l.testa);
	}

	private static int calcolaLunghezzaR(Nodo n) {
		if (n == null)
			return 0;
		return 1 + calcolaLunghezzaR(n.getSucc());
	}
}