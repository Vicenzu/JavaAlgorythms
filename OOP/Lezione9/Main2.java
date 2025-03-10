package Lezione9;

public class Main2 {
    public static void main(String[] args) {
        BadPair badPair1 = new BadPair("pippo", 8);
        BadPair badPair2 = new BadPair(4.0, "ciao");

        System.out.println(badPair1.getFirst());
        System.out.println(badPair1.getFirst().getClass());

        String s1 = (String) badPair1.getFirst();   //qui per farlo mi devo assumere la resp. del casting
        System.out.println(s1);



        Pair<String, Double> pair1 = new Pair<>("pippo", 8.0);
        System.out.println(pair1.getSecond());
        //e adesso posso
        String s = pair1.getFirst();


    }
}
