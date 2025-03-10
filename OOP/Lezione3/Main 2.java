package Lezione3;

public class Main {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        //NON POSSO
        //Point2D p = new Point2D(3,4);

        Point2D p = new CartesianPoint2D(3,4);
        System.out.println(p.getMod());
        System.out.println(p.distance(p));

        Point2D p1 = new PolarPoint2D(2, 0);
        System.out.println(p1.getX());

        //A COSA SERVE L'INTERFACE NEL PRATICO?
        /* posso avere un array che contiene indistintamente CartesianPoint2D o PolarPoint2D, in quanto
         * entrambe le classi implementano la classe Point2D, e l'array è di tipo Point2D
         */
        System.out.println(Point2DUtil.middleX(new Point2D[] {p, p1}));


        //POLIMORFISMO
        /* sebbene p3 e p4 puntino allo stesso oggetto, l'oggetto è POLIMORFICO, quindi è di tipo diverso
         * a seconda da quale variabile accedo all'oggetto
         * in questo caso se vi accedo da p3 è un PolarPoint2D, mentre se vi accedo da p4 è un Point2D
         * di conseguenza solo da p3 posso invocare metodi propri di PolarPoint2D, ma non dichiarati nella
         * interfaccia Point2D
         */
        PolarPoint2D p3 = new PolarPoint2D(3, 4);
        Point2D p4 = p3;    //posso farlo
        p3.sayHello();
        //System.out.println(p4.sayHello()); non posso
        //p3 = p;   non posso
    }
}
