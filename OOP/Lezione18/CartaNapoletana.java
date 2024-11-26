package Lezione18;

public record CartaNapoletana(Valore value, Seme seme){
    //definire queste variabili è molto sconvenienete, quindi ci possiamo creare una classe Seme e Valore
    public static final String BASTONI = "bastoni", COPPE = "Coppe", SPADE = "spade", ORO = "oro";
    public static final int RE = 10, CAVALLO = 9, DONNA = 8;


}
