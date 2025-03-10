package Esercitazione7;

public interface Denaro extends Comparable<Denaro> {
    double getValore();
    int getQuantita();
    void setQuantita(int quantita);
    double getSomma();
    boolean equals(Object o);
    String toString();
    int hashCode();

    @Override
    default int compareTo(Denaro o) {
        return Double.compare(this.getValore(), o.getValore());
    }

}
