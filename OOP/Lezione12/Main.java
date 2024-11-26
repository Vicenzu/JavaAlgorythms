package Lezione12;

import oop.range.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Range r = new Range(0, 10);
        Stack<Integer> stack = new UnboundedStackArray<>(150);
        stack.pushAll(r);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        Stack<Number> stack2 = new UnboundedStackArray<>(150);
        for (Integer i : r) stack2.push(i);

        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop());
        }

        List<Double> list = new ArrayList<Double>();
        list.add(6.9);
        list.add(6.8);
        stack2.pushAll(list);

        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop());
        }

        Stack<Integer> stack3 = new UnboundedListStack<>();
        stack3.pushAll(r);

        ArrayList<Number> al = new ArrayList<>();
        stack3.popAll(al);

        System.out.println(al);

    }
}
