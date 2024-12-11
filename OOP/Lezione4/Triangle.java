package Lezione4;

import oop.geom.v5.CartesianPoint2D;
import oop.geom.v5.Figure2D;
import oop.geom.v5.Point2D;
import oop.geom.v5.Point2DUtil;

public class Triangle implements Figure2D, Cloneable{
    private final oop.geom.v5.CartesianPoint2D p1;
    private final oop.geom.v5.CartesianPoint2D p2;
    private final oop.geom.v5.CartesianPoint2D p3;


    public Triangle(oop.geom.v5.Point2D p1, oop.geom.v5.Point2D p2, oop.geom.v5.Point2D p3) {
        if(Point2DUtil.aligned(p1,p2,p3))
            throw  new IllegalArgumentException();
        this.p1 = new oop.geom.v5.CartesianPoint2D(p1.getX(),p1.getY());
        this.p2 = new oop.geom.v5.CartesianPoint2D(p2.getX(),p2.getY());
        this.p3 = new CartesianPoint2D(p3.getX(),p3.getY());
    }


    public double area() {
        double l1 = p1.distance(p2);

        double l2 = p2.distance(p3);
        double l3 = p3.distance(p1);
        double s = (l1 + l2 + l3) * 0.5;

        return Math.sqrt(s * (s - l1) * (s - l2) * (s - l3));

    }

    public double perimeter() {
        return p1.distance(p2) + p2.distance(p3) + p3.distance(p1);
    }

    public oop.geom.v5.Point2D getP1() {
        return p1;
    }

    public oop.geom.v5.Point2D getP2() {
        return p2;
    }

    public Point2D getP3() {
        return p3;
    }

    @Override
    public Object clone(){ //fa una clonazione superficiale perchè dei punti interni verrà copiato solo il riferimento
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new Error(e);
        }
    }

    /*
    @Override
    public Object clone(){
        try { //anche se in questo caso i punti sono final e quindi andrebbe gestita in maniera differente
            Triangle t = (Triangle) super.clone();
            t.p1 = (CartesianPoint2D) p1.clone();
            t.p2 = (CartesianPoint2D) p2.clone();
            t.p3 = (CartesianPoint2D) p3.clone();
            return t;
        } catch (CloneNotSupportedException e) {
            throw new Error(e);
        }
    }*/
}
