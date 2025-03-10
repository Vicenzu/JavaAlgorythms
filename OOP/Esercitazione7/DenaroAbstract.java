package Esercitazione7;

import java.util.Objects;

public abstract class DenaroAbstract implements Denaro{
    private double valore;
    private int quantity;

    public DenaroAbstract() {}

    public DenaroAbstract(double valore, int quantity) {
        try {
            if (Taglio.isTaglioValue(valore))
                this.valore = valore;
        } catch (RuntimeException e) {
            throw new ValoreNonValidoException("Il valore inserito non è valido");
        }
        this.quantity = quantity;
    }

    @Override
    public double getValore() {
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
        if (!(o instanceof DenaroAbstract that)) return false;
        return this.quantity == that.quantity && Double.compare(this.valore, that.valore) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.valore, this.quantity);
    }


}
