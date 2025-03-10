package Lezione3;
public class Ellipsis {
    /*ELLIPSIS - posso passargli, oltre all'array, anche più punti in seguito (p1,p2,p3) invece m(Point2D[] ap) dove posso
     * prendere solo un array
     */
    static void m(int... a) {
        for (int i : a) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        m(1, 2, 3, 4);
    }
}
