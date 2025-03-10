package Lezione9;

import oop.geom.v5.Point2D;
import oop.geom.v5.Point2DUtil;

import java.util.Arrays;
import java.util.Comparator;

public class TestComp {
    public static void main(String[] args) {
        Point2D[] ap = new Point2D[5];
        ap[0] = Point2DUtil.makeFromCartesian(3,3);
        ap[1] = Point2DUtil.makeFromCartesian(4,4);
        ap[2] = Point2DUtil.makeFromCartesian(1,1);
        ap[3] = Point2DUtil.makeFromCartesian(-0.5,0.5);
        ap[4] = Point2DUtil.makeFromCartesian(7,7);

        Arrays.sort(ap, new Point2DModComparator());

        for (Point2D p : ap) {
            System.out.println(p);
        }

        //creo un comparatore che si comporti in maniera opposta del mio Point2DModComparator
        Comparator<Point2D> comp = new Point2DModComparator().reversed();
        Arrays.sort(ap, comp);

        for (Point2D p : ap) {
            System.out.println(p);
        }
    }
}
