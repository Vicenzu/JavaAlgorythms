package Lezione6;
/*Le classi astratte servono per definire parzialmente dei tipi di dati, per esempio non possiamo fare
* la new e creare un oggetto di tipo Base. A differenza delle interfacce possiamo inserire delle variabili
* d'istanza, metodi, costruttore, fare l'override per i metodi di Object (unica classe soprastante)*/
public abstract class Base /*extends Object (implicito)*/{
    private int v;

    public Base(int v) {
        this.v = v;
    }

    public int getV() {
        return v;
    }

    @Override
    public String toString() {
        return "Base [v=" + v + "]";
    }

    public abstract void m(); /*è la stessa cosa che facciamo nelle interfacce, quindi le classi sottostanti
    dovranno implementare i metodi definiti abstract*/
}
