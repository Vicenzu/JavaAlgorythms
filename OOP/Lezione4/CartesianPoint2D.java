package Lezione4;
import java.awt.*;
import java.util.Objects;

import static java.lang.Math.*;

/* per implementare l'interfaccia faccio come segue: (per mantenere la promessa TOTALMENTE)*/

                              ////////////////// posso anche implementare più interfacce
public class CartesianPoint2D extends AbstractPoint2D implements Point2D, Cloneable{
    private double x;
    private double y;


    public CartesianPoint2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public CartesianPoint2D() {
    }

    //Costruttore per copia
    public CartesianPoint2D(Point2D cp) {
        this.x = cp.getX();
        this.y = cp.getY();
    }

    @Override
    public double getMod() {
        return sqrt(x * x + y * y);
    }

    @Override
    public double getPhase() {
        return atan2(y, x);
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }


    /* OVERRIDING - ho comunque la libertà di creare il metodo distance all'interno della classe e con @Override sarà eseguito
    * questo invece di quello di default dell'interfaccia (del supertipo in questo caso)
    */
    @Override
    public double distance(Point2D p) {
    /* non posso usare p.x in quanto NON è di tipo CartesianPoint2D, ma si rifà all'interfaccia Point2D
     * che NON ha una variabile di istanza x (o y)
     */
        double dx = getX() - p.getX();
        double dy = getY() - p.getY();
        return sqrt(dx*dx + dy*dy);
    }

    //L'equals deve rispettare tutte le caratteristiche
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj.getClass() != CartesianPoint2D.class) return false;
        CartesianPoint2D cp = (CartesianPoint2D) obj;
        return x == cp.getX() && y == cp.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(x,y);
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new Error(e);
        }
    }

//    @Override     //Possiamo anche restituire direttamente un CartesianPoint2D (non consigliato)
//    public CartesianPoint2D clone() {     //facciamo il cast direttamente dentro il metodo
//        try {
//            return (CartesianPoint2D) super.clone();
//        } catch (CloneNotSupportedException e) {
//            throw new Error(e);
//        }
//    }

        // Facciamo finta che vogliamo implementarlo in maniera differente
//        @Override
//        public Object clone() {
//            return new CartesianPoint2D(this)
//        }
// è sbagliato poichè se andiamo a fare la clone di un oggetto erede di CartesianPoint2D sarà definito come
// CartesianPoint2D quindi cambiamo il tipo dell'oggetto. Ciò si può fare solo se la classe è final

}
