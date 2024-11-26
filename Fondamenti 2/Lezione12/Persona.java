package Lezione12;
import IO.*;
/*In questo file non verrà definito il main perchè verrà utilizzato per definire le classi */
public class Persona {
	//definiamo i "Campi della Classe"
	private String nome;
	private String cognome;
	private int eta;
	private NumeroTelefonico NumeroTelefonico;


	public Persona() {
		this.nome = "a";
		this.cognome = "b";
	}
	
	public Persona(String nome, String cognome, int eta) {
		this.nome = nome;   //per definire delle variabili con lo stesso nome utiliziamo this.xxx
		this.cognome = cognome;
		this.eta = eta;
	}

	//COSTRUTTORE PER COPIA - Prende come argomento una persona già esistente ma il numero telefonico può ancora cambiare
	public void PersonaShallow(Persona p) {
		this.nome = p.nome;
		this.cognome = p.cognome;
		this.eta = p.eta;
		this.NumeroTelefonico = p.NumeroTelefonico;
	}

	//DEEP COPY
	public Persona(Persona p) {
		this.nome = p.nome;
		this.cognome = p.cognome;
		this.eta = p.eta;
		this.NumeroTelefonico = new NumeroTelefonico(p.NumeroTelefonico);
	}


	public String getNome() {
		return this.nome;
	}
	
	public String getCognome() {
		return this.cognome;
	}
	
	public int getEta() {
		return this.eta;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public void setEta(int eta) {
		this.eta = eta;
	}
	
	

	/*Creazione Metodi Classe (es. creiamo un metodo che restituisce una stringa data da nome e cognome)*/
	public String soloNomeECognome() {
		return this.nome+" "+this.cognome;
	}


	/*Metodo toString() molto frequente che restituisce la conversione in stringa dell'oggetto 
	Una volta creato il metodo, se io stampo direttamente l'oggetto nel main non mi stamperà l'indirizzo di memoria
	bensì farà direttamente uso del metodo toString()*/
	public String toString() {
        return "Nome: " + this.nome + ", Cognome: " + this.cognome + ", Età: " + this.eta;
    }

	//Esempio di metodo che legge da input i campi
	public static Persona leggiDaInput(Persona p) {
		p.nome = IO.readString("Dimmi il nome: ");
		p.cognome = IO.readString("Dimmi il cognome: ");
		p.eta = IO.readInt("Dimmi l'età: ");
		return p;
	}


	//Esempio metodo statico
	public static void stampa(Persona p) {
		IO.println("Questa è un'invocazione del metodo statico STAMPA");
		IO.println("La persona passata come argomento si chiama " + p.getNome() + " " + p.getCognome());

		/*Nei metodi statici non si può usare "this", in quanto non prendono oggetti come prefissi
		this.nome <-- NO */
	}

	//Posso chiamare due metodi statici e dinamici allo stesso modo

	public void stampa() {
		IO.println("Questa è un'invocazione del metodo dinamico STAMPA");
		IO.println("La persona passata come argomento si chiama " + this.nome + " " + this.cognome);
	}

	//Metodo che restituisce una nuova persona
	public static Persona creaPersona() {
		IO.println("Creo un nuovo oggetto persona leggendo i suoi dati da input");

		Persona p = new Persona();

		p.setNome(IO.readString("Scrivi il nome: "));		
		p.setCognome(IO.readString("Scrivi il cognome: "));
		
		while (p.getEta() <= 0)
			p.setEta(IO.readInt("Scrivi l'età: "));

		return p;
	}

	//Metodo che prende in input due persone e restituisce il nome della più piccola tra le due
	//Forma statica
	public static String etaMinore(Persona p, Persona q) {
		if (p.getEta() < q.getEta())
			return p.soloNomeECognome();
		return q.soloNomeECognome();
	}

	//Forma dinamica
	public String etaMinore(Persona p) {
		if (this.eta < p.getEta())
			return this.nome + " " + this.cognome;
		return p.soloNomeECognome();
	}

	//Metodo EQUALS - di default uguale a == (se non lo definiamo)

	/*In java, il metodo equals può essere utilizzato in maniera flessibile comparando anche oggetti di tipo diverso
	 * (per esempio una persona e un cliente tramite Nome e Cognome).
	 * Per fare ciò si utilizza una classe generica object - che può ricevere un oggetto di qualsiasi tipo,
	 * poi i limiti vanno messi, eventualmente, dentro al codice
	 * 
	 * Questo metodo può essere chiamato solamente su oggetti non null (this non sarà mai null)*/
	public boolean equals (Object o) {
		if (this == o)
			return true;
		if (o instanceof Persona) {//con instanceof dichiariamo le classi desiderate (la funzione instanceof verifica già se è null)
			//adesso sappiamo che o è un tipo Persona, quindi facciamo un casting di tipo persona
			Persona p = (Persona)o; //adesso possiamo accedere alle informazioni di o tramite l'oggetto p di tipo Persona
			
			if (this.nome != null || this.cognome != null || p.nome != null || p.cognome != null) {
				//Quindi iniziamo il confronto
				if (this.nome.equalsIgnoreCase(p.nome) && this.cognome.equalsIgnoreCase(p.cognome) && this.eta == p.eta)
					return true;
			}
			return false;
		}
		else if (o instanceof Cliente) {
			Cliente c = (Cliente)o;
			if (this.nome != null || this.cognome != null || c.getNome() != null || c.getCognome() != null) {
				if (this.nome.equalsIgnoreCase(c.getNome()) && this.cognome.equalsIgnoreCase(c.getCognome()))
					return true;
			}
			return false;
		}
		
		return false;
	
	}

	


}