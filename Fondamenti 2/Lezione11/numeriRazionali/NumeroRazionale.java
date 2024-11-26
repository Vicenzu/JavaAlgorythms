package Lezione11.numeriRazionali;
public class NumeroRazionale {
    private int numeratore;
    private int denominatore;

    //costruttore base
    public NumeroRazionale() {
        this.numeratore = 0;
        this.denominatore = 1;
    }

    //costruttore a due variabili
    public NumeroRazionale(int n, int d) {
        this.numeratore = n;
        

        if (d > 0) {
            this.denominatore = d;
        }

        if (d < 0) {
            this.denominatore = d;
            this.normalizza();
        }

        if (this.denominatore != 0) {
            this.minimiTermini();
        }

        if (this.denominatore == 0)
            throw new IllegalArgumentException("Il denominatore non può essere 0");
    }

    //Metodo che porta in forma normale il numero razionale (il segno meno, se presente, sempre al numeratore)
    private void normalizza() {
        if (this.denominatore < 0) {
            this.numeratore *= -1;
            this.denominatore *= -1;
        }
    }

    /*Per evitare di fare la scomposizione in fattori primi utilizziamo il metodo di euclide:
    -se a è multiplo di b, il MCD è b
    -sennò, l'MCD è l'MCD tra b e il resto di a diviso b */
    private static int MCD(int a, int b) {
        if (a%b == 0) {
            return b;
        }
        return MCD(b, a%b);
    }

    //supponiamo che sia numeratore che denominatore siano già in "forma normale"
    private void minimiTermini () {
        boolean positivo = this.numeratore > 0;
        if (!positivo) 
            this.numeratore *= -1;
        
        int mcd = MCD(this.numeratore, this.denominatore);
        this.numeratore /= mcd;
        this.denominatore /= mcd;

        if (!positivo)
            this.numeratore *= -1;
    }

    public int getNumeratore() {
        return numeratore;
    }

    public int getDenominatore() {
        return denominatore;
    }
    
    public String toString () {
        return this.numeratore+"/"+this.denominatore;
    }

    // A/B + C/D  == numeratore(D*A + B*C)/(B*D)denominatore
    //dinamico
    public NumeroRazionale somma(NumeroRazionale n) {
        return new NumeroRazionale((this.numeratore*n.denominatore+this.denominatore*n.numeratore), 
                                    this.denominatore*n.denominatore);
    }

    //statico
    public static NumeroRazionale somma(NumeroRazionale n, NumeroRazionale n1) {
        return new NumeroRazionale((n1.numeratore*n.denominatore+n1.denominatore*n.numeratore), 
                                    n1.denominatore*n.denominatore);
    }

    //dinamico
    public NumeroRazionale prodotto(NumeroRazionale n) {
        return new NumeroRazionale(this.numeratore*n.numeratore, this.denominatore*n.denominatore);
    }

    //statico
    public static NumeroRazionale prodotto(NumeroRazionale n, NumeroRazionale n1) {
        return new NumeroRazionale(n.numeratore*n1.numeratore, n.denominatore*n1.denominatore);
    }

    //dinamico
    public NumeroRazionale divisione(NumeroRazionale n) {
        return new NumeroRazionale(this.numeratore * n.denominatore, this.denominatore * n.numeratore);
    }

    //statico
    public static NumeroRazionale divisione(NumeroRazionale n, NumeroRazionale n1) {
        return new NumeroRazionale(n.numeratore * n1.denominatore, n.denominatore * n1.numeratore);
    }

    public NumeroRazionale inverso() {
        return new NumeroRazionale(this.denominatore, this.numeratore);
    }
}
