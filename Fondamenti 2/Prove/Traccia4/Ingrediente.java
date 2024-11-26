package Prove.Traccia4;

public class Ingrediente {
    private String codice;
    private String nome;
    private float costoUnitario;
    private boolean adattoVegetariani;

    public Ingrediente(String codice, String nome, float costoUnitario, boolean adattoVegetariani) {
        this.codice = codice;
        this.nome = nome;
        this.costoUnitario = costoUnitario;
        this.adattoVegetariani = adattoVegetariani;
    }

    public String getCodice() {
        return codice;
    }

    public String getNome() {
        return nome;
    }

    public float getCostoUnitario() {
        return costoUnitario;
    }

    public boolean adattoVegetariani() {
        return adattoVegetariani;
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        
        if (!(o instanceof Ingrediente))
            return false;

        Ingrediente i = (Ingrediente)o;
        if (i.getCodice().equals(this.codice) && i.getCostoUnitario() == this.costoUnitario && i.getNome().equals(this.nome) && i.adattoVegetariani() && this.adattoVegetariani || !i.adattoVegetariani() && !this.adattoVegetariani)
            return true;
        return false;
    }

    public String toString() {
        return "Ingrediente [codice=" + codice + ", nome=" + nome + ", costoUnitario=" + costoUnitario
                + ", adattoVegetariani=" + adattoVegetariani + "]";
    }
}
