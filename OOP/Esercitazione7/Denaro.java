package Esercitazione7;

public interface Denaro extends Comparable<Denaro>{
    float getValore();
    int getQuantity();

    default int compareTo(Denaro d2) {
      return Float.compare(this.getValore(), d2.getValore());
    }

    default float getSomma() {
        return this.getQuantity() * this.getValore();
    }

    void setQuantity(int q);
}
