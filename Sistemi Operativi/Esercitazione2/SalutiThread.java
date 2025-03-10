package Esercitazione2;
//in questo caso va trattato in maniera diversa ma possiamo estendere delle altre classi
class SalutiThreadImplementation implements Runnable {
    private String name;

    public SalutiThreadImplementation(String name) {
        this.name = name;
    }

    public void run() {
        for (int i=0; i<10; i++) {
            System.out.println("Ciao da "+name);
        }
    }
}

// se noi facciamo extends thread è direttamente erede di thread ma non possiamo estendere altre classi
public class SalutiThread extends Thread{
    public SalutiThread(String nome) {
        super(nome);
    }

    public void run() {
        for (int i=0; i<10; i++) {
            System.out.println("Ciao da "+getName());
        }
    }

    public static void main(String[] args) {
        SalutiThread sal = new SalutiThread("Primo Thread");
        sal.start();

        //dobbiamo fare un casting a Thread tramite il costruttore apposito della classe thread
        SalutiThreadImplementation sal1 = new SalutiThreadImplementation("Secondo Thread");
        Thread t = new Thread(sal1);
        t.start();
    }

}
