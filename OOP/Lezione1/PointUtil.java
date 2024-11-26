package Lezione1;

import java.awt.geom.Point2D;

public class PointUtil {

    public void middlePoint(Point2D[] ap) {
        double x = 0.0;
        double y = 0.0;
        
        for (Point2D p : ap) {
            x += p.getX();
            y += p.getY();
        }

        x = x/ap.length;
        y = y/ap.length;

        return;
    }
}
