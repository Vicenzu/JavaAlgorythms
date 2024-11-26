package Esercitazione7;
import java.util.*;

public class Vendita {
    private String ID;
    private String opera;
    private LinkedList<Integer> offerte;
    private LinkedList<String> offerenti;    

    public Vendita() {
        this.ID = null;
        this.opera = null;
        this.offerte = null;
        this.offerenti = null;
    }

    public Vendita(String iD, String opera, LinkedList<Integer> offerte, LinkedList<String> offerenti) {
        this.ID = iD;
        this.opera = opera;
        this.offerte = new LinkedList<>(offerte);
        this.offerenti = new LinkedList<>(offerenti);
    }
    
    public String getID() {
        return ID;
    }
    public void setID(String id) {
        this.ID = id;
    }
    public String getOpera() {
        return opera;
    }
    public void setOpera(String opera) {
        this.opera = opera;
    }
    public LinkedList<Integer> getOfferte() {
        return new LinkedList<>(offerte);
    }
    public void setOfferte(LinkedList<Integer> offerte) {
        this.offerte = offerte;
    }
    public LinkedList<String> getOfferenti() {
        return new LinkedList<>(offerenti);
    }
    public void setOfferenti(LinkedList<String> offerenti) {
        this.offerenti = offerenti;
    }
    
    public String toString() {
        return "" + this.ID + ", " + this.opera + ", " + this.offerte + ", " + this.offerenti;
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof Vendita))
            return false;

        Vendita v1 = (Vendita) o;

        if (this.ID == v1.ID)
            return true;
        return false;
    }   



}
