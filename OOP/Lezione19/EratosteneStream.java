package Lezione19;

import java.util.*;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class EratosteneStream {
    public static void main(String[] args) {
        final int N = 100;
        List<Integer> prime = new LinkedList<>();
        prime.add(2);
        IntStream.iterate(3, n-> n<=N, x-> x+2) //otteniamo uno stream di tutti i numeri a partire da 3
                .filter(x-> prime.stream().noneMatch(p-> x%p==0)) //ogni volta crea un nuovo stream dalla lista prime
                                        // utilizziamo gli stream per utilizzare il metodo noneMatch()
                .forEach(prime :: add);

        prime.forEach(nome -> System.out.printf("%5d", nome));
        System.out.println();

        LinkedList<Integer> prime1 = new LinkedList<>();
        prime1.add(2);

        //modo più criptico che alla fine stampa direttamente
        IntStream.iterate(3, n-> n<=N, x-> x+2)
                .filter(x-> prime1.stream().noneMatch(p-> x%p==0))
                .forEach(((IntConsumer) prime1 :: add).andThen(x-> System.out.printf("%5d", x)));
                        //Per utilizzare andThen dobbiamo fare il cast a IntConsumer
    }
}
