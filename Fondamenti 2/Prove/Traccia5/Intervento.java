package Prove.Traccia5;
import java.util.LinkedList;
import java.util.Objects;

public class Intervento {
	
	private  String nomeTecnico;
	private LinkedList <String> tipiOperazione;
	private int data;
	private int durata;
	
	public Intervento (String nomeTecnico, LinkedList <String> tipiOperazione, int data, int durata) {
		this.nomeTecnico=nomeTecnico;
		this.tipiOperazione=tipiOperazione;
		this.data=data;
		this.durata=durata;
	}

	public String getNomeTecnico() {
		return nomeTecnico;
	}

	public LinkedList<String> getTipiOperazione() {
		return tipiOperazione;
	}

	public int getData() {
		return data;
	}

	public int getDurata() {
		return durata;
	}

	@Override
	public String toString() {
		return "Intervento [nomeTecnico=" + nomeTecnico + ", tipiOperazione=" + tipiOperazione + ", data=" + data
				+ ", durata=" + durata + "]";
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Intervento))
			return false;
		Intervento other = (Intervento) obj;
		return data == other.data && durata == other.durata && Objects.equals(nomeTecnico, other.nomeTecnico)
				&& Objects.equals(tipiOperazione, other.tipiOperazione);
	}
	
	
	

}