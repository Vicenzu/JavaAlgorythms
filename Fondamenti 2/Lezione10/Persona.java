import IO.*;
/*In questo file non verrà definito il main perchè verrà utilizzato per definire le classi */
public class Persona {
	//definiamo i "Campi della Classe"
	public String nome;
	public String cognome;
	public int eta;

	/*Quando definiamo i campi, non si lasciano quasi mai "public" poichè in questo modo chiunque può accedervi,
	bensì scriviamo "private"*/


	//Facciamo in modo tale che ogni volta che si crea un oggetto persona vengano definiti nome cognome ed eta con dei valori di default
	public Persona() {

	}

	//nel caso in cui i nostri campi fossero "private" definiamo i "GETTERS AND SETTERS"
	public String getNome() {
		return this.nome;
	}

	public String getCognome() {
		return this.cognome;
	}

	public int getEta() {
		return this.eta;
	}



	public Persona(String nome, String cognome, int eta) {
		this.nome = nome;   //per definire delle variabili con lo stesso nome utiliziamo this.xxx
		this.cognome = cognome;
		this.eta = eta;
	}

	/*Possiamo sia definire o nessun costruttore oppure definire sia quello senza parametri (Costruttore()) 
	che quello con (Costruttore(x, y, z)), altrimenti java ci darà errore se ne creiamo uno a tre parametri 
	e nel main proviamo a stamparne uno senza*/


	/*Creazione Metodi Classe (es. creiamo un metodo che restituisce una stringa data da nome e cognome)*/
	public String soloNomeECognome() {
		return this.nome+" "+this.cognome;
	}


	/*Metodo toString() molto frequente che restituisce la conversione in stringa dell'oggetto 
	Una volta creato il metodo, se io stampo direttamente l'oggetto nel main non mi stamperà l'indirizzo di memoria
	bensì farà direttamente uso del metodo toString()*/
	public String toString() {
		return "Nome: "+this.nome+ "; " +
				"Cognome: "+this.cognome+ "; "+
				"Età: "+this.eta;
	}

	//Esempio di metodo che legge da input i campi
	public void leggiDaInput() {
		this.nome = IO.readString("Dimmi il nome: ");
		this.cognome = IO.readString("Dimmi il cognome: ");
		this.eta = IO.readInt("Dimmi l'età: ");
	}

	private int ciola;

	//Getter
	public int getCiola() {
		return this.ciola;
	}

	//Setter
	public void setCiola(int a) {
		this.ciola = a;
	}
}