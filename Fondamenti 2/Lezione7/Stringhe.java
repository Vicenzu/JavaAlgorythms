import IO.*;
public class Stringhe {
    public static void main(String[] args) {
        String s = "Ciao";
        String s1 = " a tutti canaglia dio.";
        IO.println(s+s1);
    
        String s2 = "Ciao a tutti canaglia dio.";
        IO.println(s2);
    
        //Apparentemente le due stringhe s+s1 e s2 sembreranno uguali, ma punteranno a diversi indirizzi di memoria
        IO.println((s+s1)==s2); //-> false

        //come verifico se due stringhe sono uguali? con il metodo "equals"
        IO.println((s+s1).equals(s2));

        //Per accedere ad un carattere di una stringa possiamo utilizzare il metodo "charAt"
        IO.println(s2.charAt(0));

        //per verificare se una stringa contiene una sequenza di caratteri utilizziamo "contains" 
        IO.println(s2.contains("ao"));

        //Le stringhe possono essere modificate attraverso la concatenazione, ma sono immutabili
        s = s+"xyz";

        /*Di fatto la stringa verrà modificata visivamente, ma in memoria punterà ad un'indirizzo diverso.*/

        //Per modificare una stringa utilizziamo il metodo "replace", assegnandolo ad un altra variabile
        String s_diverso = s.replace("C", "Ziopera");
        IO.println(s_diverso);
    }
}
