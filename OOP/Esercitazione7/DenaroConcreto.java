package Esercitazione7;

public class DenaroConcreto implements Denaro{
    private float valore;
    private int quantity;

    public DenaroConcreto() {}

    public DenaroConcreto(float valore, int quantity) {
        try {
            if (Taglio.isTaglioValue(valore))
                this.valore = valore;
        } catch (RuntimeException e) {
            throw new ValoreNonValidoException("Il valore inserito non è valido");
        }
        this.quantity = quantity;
    }

    @Override
    public float getValore() {
        return valore;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int q) {
        if (q < 0) throw new QuantitaNonValidaException("Quantità non valida");
        quantity = q;
    }

    @Override
    public String toString() {
        return "Quantità: "+ quantity+", Taglio: "+valore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DenaroConcreto that)) return false;
        return this.quantity == that.quantity && this.valore- that.valore == 0;
    }

    @Override
    public int hashCode() {
        int ret = 17;

    }

}
