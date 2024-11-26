package Lezione1;
import static java.lang.Math.*;

/*Facciamo in modo che chi utilizza la classe dall'esterno non noti nessuna differenza, ricevendo in input e dando in output
 * sempre e comunque coordinate cartesiane
 */

@SuppressWarnings("unused")
public class Point2DPolar {
    private double mod; // modulo
    private double ph; // fase

    public Point2DPolar(double x, double y){
        mod = Math.sqrt(x*x + y*y);
        ph = Math.atan2(x, y);
    }

    public double getX() {
        return Math.cos(mod)*ph;
    }

    public double getY() {
        return mod*Math.sin(ph);
    }

}