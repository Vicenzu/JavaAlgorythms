package Lezione12;
import IO.*;
public class MainCliente {
   
    public static void main(String[] args) {
        Cliente c1 = new Cliente("A", "B", 20, new int[] {1, 2, 3});
        
        Cliente clalias = c1; //In questo caso il puntatore di clalias punterà direttamente alla cella di memoria di c1
        Cliente c2 = new Cliente(c1); //Qui abbiamo una new e quindi si creerà un spazio nell'heap contenente gli stessi valori di c1
        Cliente c3 = new Cliente();
        Cliente.ClienteShallow(c1, c3);
        

        c1.setEta(c1.getEta()+1);
        c1.getNumeriFortunati()[0] = 100;
        IO.println("Cliente originale " + c1);
        IO.println("Cliente Alias " + clalias);
        IO.println("Cliente shallow copy " + c3);
        IO.println("Cliente deep copy " + c2);
    
        IO.println();

       

        Persona p = new Persona();
        //Persona.leggiDaInput(p);

        //Confronto tra tipo Persona e Cliente
        IO.println(p.equals(new Cliente("Vincenzo", "Calogero", 20, new int[] {1,2,3})));

        IO.println(c1.equals(clalias));
    }
}