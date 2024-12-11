package Esercitazione6;

import java.io.*;
import java.util.LinkedList;

class Oggetto {
    private final String name;
    private int quantity;

    public Oggetto(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

public class MagazzinoEdile implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private final LinkedList<Oggetto> oggetti;

    public MagazzinoEdile(String name, int quantity) {
        this.oggetti = new LinkedList<>();
        oggetti.add(new Oggetto(name, quantity));
    }

    public MagazzinoEdile(Oggetto obj) {
        this.oggetti = new LinkedList<>();
        oggetti.add(obj);
    }

    public void add(String name, int quantity) {
        for (Oggetto o : oggetti) {
            if (o.getName().equalsIgnoreCase(name))
                o.setQuantity(quantity+o.getQuantity());
        }
        oggetti.add(new Oggetto(name, quantity));
    }

    @Override
    public String toString() {
        return "MagazzinoEdile{" +
                "oggetti=" + oggetti +
                '}';
    }
}
