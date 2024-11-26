package Lezione8;

public class Main {
    public static void main(String[] args) {
        //Tipo troppo generico
        BadPair p1 = new BadPair("Pippo", 8);
        BadPair p2 = new BadPair(4, "Ciao");

        //Utilizziamo il Pair parametrico
        PairT<String> p3 = new PairT<>("Ciao", "Pippo");

    }
}
