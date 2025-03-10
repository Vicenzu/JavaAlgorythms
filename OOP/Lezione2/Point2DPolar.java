package Lezione2;

/* riprogettiamo la classe Point2D utilizzando invece delle coordinate cartesiane, quelle polari
 * 
 * OSSERVAZIONE: faremo in modo che chi utilizza la classe non noti alcuna differenza, ricevendo in input
 * e fornendo in output comunque coordinate cartesiane (esempio di INCAPSULATION)
 */

public class Point2DPolar {
    private double mod; //modulo
    private double ph;  //fase

    //nel costruttore ricevo comunque le coordinate cartesiane
    public Point2DPolar(double x, double y) {
        this.mod = Math.sqrt(x*x + y*y);
        this.ph = Math.atan2(y, x);
    }

    public double getX() {
        return mod * Math.cos(ph);
    }

    public double getY() {
        return mod * Math.sin(ph);
    }
}
