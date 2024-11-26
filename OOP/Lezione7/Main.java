package Lezione7;

public class Main {
    public static void main(String[] args) {
        Rectangle r = new Rectangle(4,5);

        double a1 = r.area();
        r.setBase(r.getBase()*2.0);

        double a2 = r.area();
        boolean b = a1*2.0 == a2;
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(b);

        Square s = new Square(5);
        r=s;

        Circle c = new Circle(-5); //Ci uscirà la nostra eccezione Negative Radius
    }
}
