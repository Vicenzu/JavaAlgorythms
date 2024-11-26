package Prove.Traccia5;

import java.util.Objects;

public class Tecnico {
	
	private String nome;
	private int costoOrario;

	public Tecnico() {
    }

    public Tecnico (String nome, int costoOrario) {
		this.nome=nome;
		this.costoOrario=costoOrario;
	}

    

	@Override
	public String toString() {
		return "Tecnico [nome=" + nome + ", costoOrario=" + costoOrario + "]";
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Tecnico))
			return false;
		Tecnico other = (Tecnico) obj;
		return costoOrario == other.costoOrario && Objects.equals(nome, other.nome);
	}

    public String getNome() {
        return nome;
    }

    public int getCostoOrario() {
        return costoOrario;
    }
}