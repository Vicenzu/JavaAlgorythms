package Lezione7;

import oop.geom.v5.Point2D;

import java.util.Comparator;

public class Point2DModComparator implements Comparator<oop.geom.v5.Point2D> {

    @Override
    public int compare(Point2D o1, Point2D o2) {
        if (o1.getMod() == o2.getMod())
            return 0;
        else if (o1.getMod() < o2.getMod()) {
            return -1;
        }
        return 1;
    }
}