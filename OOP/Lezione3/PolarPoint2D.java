package Lezione3;

import static java.lang.Math.*;

public class PolarPoint2D implements Point2D {
    private double mod;
    private double ph;

    public PolarPoint2D(){}

    public PolarPoint2D(double mod, double ph) {
        this.mod = mod;
        this.ph = ph;
    }

    @Override
    public double distance(Point2D p) {
        double dx = getX() - p.getX();
        double dy = getY() - p.getY();
        return sqrt(dx*dx + dy*dy);
    }

    @Override
    public double getMod() {
        return mod;
    }

    @Override
    public double getPhase() {
        return ph;
    }

    @Override
    public double getX() {
        return mod*cos(ph);
    }

    @Override
    public double getY() {
        return mod*sin(ph);
    }
    
    //non posso chiamarlo da una variabile Point2D, in quanto l'interfaccia non lo include
    public void sayHello() {
        System.out.println("Hello");
    }
}
