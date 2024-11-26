package Prove.Traccia2;

public class Scuderia {
    private String nome;
    private String citta;
    private float compensoExtra;
    
    public Scuderia(String nome, String citta, float compensoExtra) {
        this.nome = nome;
        this.citta = citta;
        this.compensoExtra = compensoExtra;
    }

    public String getNome() {
        return nome;
    }

    public String getCitta() {
        return citta;
    }

    public float getCompensoExtra() {
        return compensoExtra;
    }

    public String toString() {
        return "Scuderia [nome=" + nome + ", citta=" + citta + ", compensoExtra=" + compensoExtra + "]";
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof Scuderia))
            return false;
        
        Scuderia s = (Scuderia)o;
        if (s.getCitta().equals(this.citta) && s.getCompensoExtra() == this.compensoExtra && s.getNome().equals(this.nome))
            return true;
        return false;
    }
    
}
