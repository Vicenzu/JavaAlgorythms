package Lezione7;

public class NegativeRadiusExeption extends IllegalArgumentException{
    public NegativeRadiusExeption() {}

    public NegativeRadiusExeption(String s) {
        super(s);
    }
}
