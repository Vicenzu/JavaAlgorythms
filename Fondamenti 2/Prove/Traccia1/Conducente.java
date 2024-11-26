package Prove.Traccia1;
import java.util.*;
public class Conducente {
	private String nome;
	private LinkedList<String> viaggi;
	
	public Conducente(String nome, LinkedList<String> viaggi) {
		this.nome = nome;
		this.viaggi = new LinkedList<>(viaggi);
	}

	public String getNome() {
		return nome;
	}

	public LinkedList<String> getViaggi() {
		return new LinkedList<>(viaggi);
	}
	
	public String toString() {
		return nome + ", " + new LinkedList<>(viaggi);
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		
		if (!(o instanceof Conducente))
			return false;

		Conducente c = (Conducente)o;
		if (this.nome.equals(c.nome) && this.viaggi.equals(c.viaggi)) 
			return true;
		return false;
	}
}
