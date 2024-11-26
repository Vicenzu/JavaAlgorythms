package Lezione4;

import static oop.geom.v1.Point2D.EPS;

//Una classe astratta mi consente di non dover scrivere i metodi di Point2D
/* Dunque dato che questa classe implements Point2D allora in tutte le classi che estenderanno questa non
* dovranno implementare Point2D */
public abstract class AbstractPoint2D implements Point2D{

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Point2D p) {
            return p.distance(this) <= EPS;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int res = 17;
        double x = getX();
        long lx = Double.doubleToLongBits(x);
        res = res*31 + (int)(lx^(lx>>>32));

        double y = getY();
        long ly = Double.doubleToLongBits(y);
        res = res*31 + (int)(ly^(ly>>>32));

        return res;
    }
}
