package Lezione3;

public class Point2DUtil {
    public static double middleX(Point2D[] ap) {
        double xm = 0.0;

        for (Point2D p : ap) {
            xm += p.getX();
        }

        return xm/ap.length;
    }

    public static double middleY(Point2D[] ap) {
        double ym = 0.0;

        for (Point2D p : ap) {
            ym += p.getY();
        }

        return ym/ap.length;
    }

    /* sto creando dei metodi su un tipo di cui non ho la classe, ma solo l'interfaccia, che "promette" che
     * i metodi dichiarati astrattamente all'interno dell'interfaccia esistano da qualche parte
     */
}
