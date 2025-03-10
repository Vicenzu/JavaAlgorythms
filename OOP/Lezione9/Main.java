package Lezione9;

public class Main {
    public static void main(String[] args) {
        Object o = new Object();

        o = 1;
        System.out.println(o.getClass());

        o = 1.0;
        System.out.println(o.getClass());

        o = 1L;
        System.out.println(o.getClass());


        //Wrapper classes

        Integer i1 = 1;
        //Integer i1 = new Integer(1); non si può fare dalla versione 9 di java
        /* mi dà il warning in quanto è uno spreco di memoria creare un nuovo oggetto Integer
        * per ogni valore che utilizzo, in quanto sono immutabili. Basta infatti crearne uno
        * solo e riutilizzarlo tutte le volte che si vuole.
        * Infatti utilizzando Integer i = 1; viene prima verificato se ci sono altri oggetti
        * Integer che hanno il valore di 1. */

        //Boxing
        i1 = Integer.valueOf(1);

        //Unboxing
        int v = i1;
        /* dietro le quinte invoca il metodo i1.intValue() che restituisce il corrispettivo int */

        double d = i1;
        //posso assegnare un Integer a un double, ma ovviamente non viceversa
        //NO i1 = 1.0;


        /* I tipi Wrapper sono in realtà eredi della classe astratta java.lang.Number
        che contiene anche dei metodi interessanti come intValue(), doubleValue(), ecc.
         */

        //casting da stringa
        i1 = Integer.valueOf("42");

        //stringa con base(2)
        i1 = Integer.valueOf("100", 2);
        System.out.println(i1);


        i1 = 4;
        Integer i2 = 5;
        System.out.println(i1.compareTo(i2));
        //-1 perché 4 precede 5
    }
}
