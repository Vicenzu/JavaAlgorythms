package Esercitazione3;

public class StampanteT extends Thread{
    private int da, a;

    public StampanteT(int da, int a) {
        this.da = da;
        this.a = a;
    }

    public void run() {
        for (int i=da; i<=a; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StampanteT s1 = new StampanteT(1,10);
        StampanteT s2 = new StampanteT(11, 20);
        s1.start();
        //s2.start();
        //System.out.println("Fine");
        /*Notiamo come l'output sarà interfogliato poiché l'output non è deterministico*/
        System.out.println();

        try {
            s1.join();
        } catch (InterruptedException e) {
            System.out.println("cacca");
        }




        System.out.println("Fine");


    }
}

