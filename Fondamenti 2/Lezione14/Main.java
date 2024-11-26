package Lezione14;
import IO.*;
import Lezione11.NumeroTelefonico;

public class Main {
    public static void main(String[] args) {
        //creiamo una coppia di stringhe - Java sostituirà il tipo T con String
        Coppia<String> cs = new Coppia<>();
        cs.setElem1("Primo elemento");
        cs.setElem2("Secondo elemento");

        Coppia<NumeroTelefonico> cnt = new Coppia<>();
        cnt.setElem1(new NumeroTelefonico("0984", "494744"));

        /*Per fare una coppia di int non posso fare Coppia<int> poichè è un tipo di base, ma T deve essere una classe
         *
         * Possiamo utilizzare la classe di default Integer di Java chiamata "Wrapper Class"*/
        Coppia<Integer> coppiaint = new Coppia<>();
        coppiaint.setElem1(324);

        Integer a = 32;
        Integer b = 64;
        Integer c = a+b;
        IO.println("Somma: " + (a+b+c)); //Dobbiamo utilizzare le parentesi sennò concatenerà i numeri alla stringa
        //Essendo una classe Integer, quando andremo a fare la somma degli altri due tipi Integer, farà un type-casting
        // per poter fare la somma

        int a1 = a.intValue(); //restituisce il rispettivo int (come quando fa la somma)
        IO.println(a1);

        Integer x1 = 32; //Per numeri piccoli (dipende dalla jvm installata, generalmente <100; dato che gli Integer sono
        Integer x2 = 32; // tipi immutabili) assegna a entrambi le variabili lo stesso puntatore, mentre per 
        if (x1 == x2)     // numeri più grandi verrà creato un nuovo puntatore e quindi un nuovo indirizzo di memoria
            IO.println("Numeri Uguali");// (l' == verifica gli indirizzi in questo caso)
        else   
            IO.println("Numeri Diversi");

        //Metodi statici che restituiscono il numero più piccolo e più grande della classe int
        IO.println(Integer.MIN_VALUE);
        IO.println(Integer.MAX_VALUE);

        
        //Per comparare i vari tipi non si può utilizzare il < e il > ma per la classe Integer si, perchè richiama
        // .intValue(), anche se conviene sempre utilizzare il metodo .compareTo() per i tipi non di base
        if (a.compareTo(b)>0)
            IO.println("a > b");
 
        Integer[] array = new Integer[4];
        array[0] = 4;
        array[1] = 1;
        array[2] = 3;
        array[3] = 5;

        Coppia<Integer> minimoMassimo = Coppia.minMax(array);
        IO.println(minimoMassimo); 
        // NB. possiamo utilizzare il metodo minMax anche con i tipi Stringa e altri...
        
        
    }
}
