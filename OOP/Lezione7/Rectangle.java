package Lezione7;

public class Rectangle implements Figure2D{
    private double base;
    private double height;

    public Rectangle(double base, double height) {

        //che succede se sono <=0?
        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        return base*height;
    }

    @Override
    public double perimeter() {
        return 2*(base+height);
    }

    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public void setHeight(double height) {
        this.height = height;
    }


}
