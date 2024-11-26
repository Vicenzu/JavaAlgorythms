package Prove.Traccia2;

public class Pilota {
    private String nome;
    private int eta;
    private float compensoPerGara;
    
    public Pilota(String nome, int eta, float compensoPerGara) {
        this.nome = nome;
        this.eta = eta;
        this.compensoPerGara = compensoPerGara;
    }

    public String getNome() {
        return nome;
    }

    public int getEta() {
        return eta;
    }

    public float getCompensoPerGara() {
        return compensoPerGara;
    }

    public String toString() {
        return "Pilota [nome=" + nome + ", eta=" + eta + ", compensoPerGara=" + compensoPerGara + "]";
    }

    public boolean equals(Object o) {
        if (this == o) 
            return true;

        if (!(o instanceof Pilota))
            return false;

        Pilota g = (Pilota)o;
        if (this.compensoPerGara == g.getCompensoPerGara() && this.eta == g.getEta() && this.nome.equals(g.getEta()))
            return true;
        return false;
    }
}