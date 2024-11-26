package Lezione18;

public class TestRecord {
    public static void main(String[] args) {
        Punto p1 = new Punto(3.1,4.0);
        double x = p1.x(); //come vediamo, fa anche i metodi get
        double y = p1.y();
        Punto p2 = new Punto(3.1,4.0);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println("P1 è uguale a P2? "+p1.equals(p2));
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());

    }
}
