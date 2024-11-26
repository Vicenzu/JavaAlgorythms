package Lezione4;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

///////
public interface Point2D {
    /* In un interface definisco solo cosa voglio fare, e non com'è fatto il punto.
     * Come la definizione di un metodo, ma non implementato (astratto) - ovvero una "promessa" che sia implementato da qualche altra parte
     * Qualunque metodo di un interfaccia è sia public che abstract
     */
    double getX();
    double getY();
    double getMod();
    double getPhase();

    //METODO DI DEFAULT - ci evita di introdurlo all'interno della classe
    default double distance(Point2D p) {
        double dx = getX() - p.getX();
        double dy = getY() - p.getY();
        return Math.sqrt(dx*dx + dy*dy);
    }

    //METODO STATIC - non può essere utilizzato l'override nella classe 
    static Point2D makeFromCartesian(double x, double y) {
        return new CartesianPoint2D(x, y);
    }

    static Point2D makeFromPolar(double mod, double ph) {
        return new CartesianPoint2D(mod*cos(ph), mod*sin(ph));
    }

    default boolean equals(Point2D p) {
        return true;
    }
}