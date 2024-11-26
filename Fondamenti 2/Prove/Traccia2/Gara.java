package Prove.Traccia2;
import java.util.*;
public class Gara {
    private String id, luogo;
    private LinkedList<String> piloti, scuderie;
    
    public Gara(String id, String luogo, LinkedList<String> piloti, LinkedList<String> scuderie) {
        this.id = id;
        this.luogo = luogo;
        this.piloti = new LinkedList<>(piloti);
        this.scuderie = new LinkedList<>(scuderie);
    }

    public String getId() {
        return id;
    }

    public String getLuogo() {
        return luogo;
    }

    public LinkedList<String> getPiloti() {
        return piloti;
    }

    public LinkedList<String> getScuderie() {
        return scuderie;
    }

    public String toString() {
        return "Gara [id=" + id + ", luogo=" + luogo + ", piloti=" + piloti + ", scuderie=" + scuderie + "]";
    }

    public boolean equals(Object o) {
        if (this == o) 
            return true;

        if (!(o instanceof Gara))
            return false;

        Gara g = (Gara)o;
        if (this.id.equals(g.getId()) && this.luogo.equals(g.getLuogo()) && this.piloti.equals(g.getPiloti()) && this.scuderie.equals(g.getScuderie()))
            return true;
        return false;
    }
}
