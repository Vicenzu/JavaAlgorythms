package Lezione10;

public class Outer {
    private int a;

    public class Inner {
        private int k;

        public void m() {
            k++; //this.k
            a++; //Outer.this.a
        }

    }

    public static class Inner2 {
        public void m() {

        }
    }
}
