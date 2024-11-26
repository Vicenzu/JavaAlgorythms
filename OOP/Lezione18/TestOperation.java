package Lezione18;

import java.util.function.BiFunction;

public class TestOperation {
    public static void main(String[] args) {
        double x = 3.8, y = 6.5;

        Operation[] ops = Operation.values();
        for (Operation op : ops) {
            System.out.println(x+ " " + op+ " " + y + " = " + op.apply(x,y));
        }

        System.out.println(applyFunction((x1, y1) -> {return x1*x1+y1*y1;}, x, y));

        System.out.println(applyFunction(Operation.PLUS :: apply,x,y));
    }


    static double applyFunction(BiFunction<Double, Double, Double> f, double x, double y) {
        return f.apply(x,y);
    }
}
