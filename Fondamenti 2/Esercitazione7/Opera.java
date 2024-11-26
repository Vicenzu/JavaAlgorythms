package Esercitazione7;

public class Opera {
    private String nome;
    private String autore;
    private int anno;

    public Opera() {
        this.nome = null;
        this.autore = null;
        this.anno = 0;
    }

    public Opera(String nome, String autore, int anno) {
        this.nome = nome;
        this.autore = autore;
        this.anno = anno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public String toString() {
        return this.nome + ", " + this.autore + ", " + this.anno;
    }

    public boolean equals(Object o) {
        if (this == o) 
            return true;

        if (!(o instanceof Opera))
            return false;

        Opera o2 = (Opera)o;

        if (this.nome.equals(o2.nome) && this.autore.equals(o2.autore) && this.anno == o2.anno) 
            return true;
        
        return false;
    }


}
