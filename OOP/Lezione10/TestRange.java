package Lezione10;

public class TestRange {
    public static void main(String[] args) {
        Range r = new Range(500_000);
        for (int i : r)
            System.out.println(i);
    }
}
