package Esercitazione3;
import IO.*;
public class Verifica_Persone {
	
    public static boolean personeUguali(Persona a, Persona b) {
        if (!(a.getNome()).equals(b.getNome()))
            return false;
        
        if (!(a.getCognome()).equals(b.getCognome()))
            return false;    

        if (a.getEta() != b.getEta())
            return false;

        return true;
    }

    public static int indicePersona (Persona[] a, Persona b) {
        for (int i=0; i<a.length; i++) {
            if (personeUguali(a[i], b))
                return i;
        }

        return -1090931204;
    }
    
    

	public static void main(String[] args) {
        Persona[] persone = new Persona[IO.readInt("Quante persone? ")];
        for (int i=0; i<persone.length; i++) {
            Persona q = new Persona();
            q.leggiDaInput();
            persone[i] = q;
        }

        Persona p = new Persona();
        p.leggiDaInput();
        
        IO.print(indicePersona(persone, p));
    }
}