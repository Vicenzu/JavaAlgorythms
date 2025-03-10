package Lezione18;

public class TestCarte {
    public static void main(String[] args) {
        CartaNapoletana c1 = new CartaNapoletana(Valore.DUE, Seme.ORO);

        System.out.println(Valore.DUE.getValue());

        for (Valore v : Valore.values()) {
            System.out.println(v);
        }


    }

    static int calcoloValoreSeme(Seme seme) {

        return switch (seme) {
            case ORO -> 10;
            case SPADE -> 5;
            default -> 1;
        };
    }


}
