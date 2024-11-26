package Lezione7;

import java.util.Scanner;

public class TestThrowable {
    public static void main(String[] args) {
        //se lo definiamo come Throwable dobbiamo scrivere nella signature del main "throws Throwable"
        //Throwable t = new Throwable("Vai Via!!!");
        //throw t;

        RuntimeException re = new RuntimeException("Vai Via!!!");
        //throw re;

        Scanner sc = new Scanner(System.in);
        boolean ok = false;
        do {
            System.out.println("Give me radius: ");
            double r = sc.nextDouble();
            Circle c = null;

            try{
                c = new Circle(r);
                System.out.println("Ecco l'area: " + c.area());
                ok=true;
            }catch (IllegalArgumentException e){
                System.out.println("Please don't joke motherfucker!");
            }
        }while (!ok);

    }
}
