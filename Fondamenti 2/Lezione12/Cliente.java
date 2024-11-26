package Lezione12;

import java.util.Arrays;

public class Cliente {
    private String nome;
    private String cognome;
    private int eta;
    private int[] numeriFortunati;

    public Cliente () {}

    public Cliente(String nome, String cognome, int eta, int[] numeriFortunati) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.numeriFortunati = numeriFortunati;
    }

    //Shallow copy
    public static Cliente ClienteShallow (Cliente originale, Cliente copia) {
        copia.nome = originale.nome;
        copia.cognome = originale.cognome;
        copia.eta = originale.eta;
        copia.numeriFortunati = originale.numeriFortunati;
        return copia;
    }

    //Deep Copy
    public Cliente (Cliente c) {
        this.nome = c.nome;
        this.cognome = c.cognome;
        this.eta = c.eta;
        
        if (c.numeriFortunati != null) {  //Controliamo che non sia null
            this.numeriFortunati = new int[c.numeriFortunati.length]; //Supponiamo che non sia null (nel caso lo sia, ci darà errore poichè non ha lenght) *prima il controllo non c'era*
            for (int i=0; i<this.numeriFortunati.length; i++) {  //Copiamo l'array
                this.numeriFortunati[i] = c.numeriFortunati[i];
            }
        }
    }


    public String toString() {
        return "Cliente [nome=" + nome + ", cognome=" + cognome + ", eta=" + eta + ", numeriFortunati="
                + Arrays.toString(numeriFortunati) + "]";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public int[] getNumeriFortunati() {
        return numeriFortunati;
    }

    public void setNumeriFortunati(int[] numeriFortunati) {
        this.numeriFortunati = numeriFortunati;
    }

    public boolean equals (Object o) {
		if (this == o)
			return true;
		if (o instanceof Persona) {//con instanceof dichiariamo le classi desiderate (la funzione instanceof verifica già se è null)
			//adesso sappiamo che o è un tipo Persona, quindi facciamo un casting di tipo persona
			Persona p = (Persona)o; //adesso possiamo accedere alle informazioni di o tramite l'oggetto p di tipo Persona
			
			if (this.nome != null || this.cognome != null || p.getNome() != null || p.getCognome() != null) {
				//Quindi iniziamo il confronto
				if (this.nome.equalsIgnoreCase(p.getNome()) && this.cognome.equalsIgnoreCase(p.getCognome()))
					return true;
			}
		}
		else if (o instanceof Cliente) {
			Cliente c = (Cliente)o;
			if (this.nome != null || this.cognome != null || c.nome != null || c.cognome != null) {
				if (this.nome.equalsIgnoreCase(c.nome) && this.cognome.equalsIgnoreCase(c.cognome) && this.eta == c.eta && verifica(this.numeriFortunati, c.numeriFortunati))
					return true;
			}
		}
		
		return false;
	
	}

    //Metodo che verifica se due array sono uguali (utilizzato per vedere se due clienti hanno gli stessi numeri fortunati)
    private static boolean verifica (int[] a, int[] b) {
        if (a.length != b.length)
            return false;
        
        if (a.length == b.length) {
            for (int i=0; i<a.length; i++) {
                if (a[i] != b[i])
                    return false;            
            }
        }
    
        return true;
    }

}
