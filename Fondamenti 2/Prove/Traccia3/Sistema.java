package Prove.Traccia3;
import IO.*;
import java.util.*;
import Prove.Traccia1.Conducente;
import Prove.Traccia1.Viaggio;
public class Sistema {
    private LinkedList<Viaggio> listaViaggi;
    private LinkedList<Conducente> listaConducenti;

    public Sistema(LinkedList<Viaggio> listaViaggi, LinkedList<Conducente> listaConducenti) {
        this.listaViaggi = new LinkedList<>(listaViaggi);
        this.listaConducenti = new LinkedList<>(listaConducenti);
    }

    public LinkedList<Viaggio> getListaViaggi() {
        return listaViaggi;
    }

    public void setListaViaggi(LinkedList<Viaggio> listaViaggi) {
        this.listaViaggi = new LinkedList<>(listaViaggi);
    }

    public LinkedList<Conducente> getListaConducenti() {
        return listaConducenti;
    }

    public void setListaConducenti(LinkedList<Conducente> listaConducenti) {
        this.listaConducenti = new LinkedList<>(listaConducenti);
    }

    /**
     * Condizioni:
     * - Nessun conducente ha un numero complessivo di ore inferiore a oreMin(il numero complessivo di ore di un 
     *  conducente è la somma delle durate dei viaggi gestite dal conducente stesso)
     * - Nessun viaggio ha un numero di passeggeri maggiore a passeggeriMax
     * @param oreMin
     * @param passeggeriMax
     * @return true se e solo se sono soddisfatte le condizioni, altrimenti false
     */
    public boolean verifica(int oreMin, int passeggeriMax) {
        for (Conducente c : listaConducenti) {
            if (!verificaOreEPasseggeri(oreMin, c.getViaggi(), passeggeriMax))
                return false;
        }
        return true;
    }
    private boolean verificaOreEPasseggeri(int oreMin, LinkedList<String> codViaggi, int passeggeriMax) {
        int totOre = 0;
        int totPasseggeri = 0;

        for (Iterator<String> it=codViaggi.iterator(); it.hasNext(); ) {
            String curr = it.next();
            for (Viaggio v : listaViaggi) {
                if (v.getCodice().equals(curr)) {
                    totOre+=v.getDurata();
                    totPasseggeri+=v.getNumPasseggeri();
                    break;
                }
            }
        }
        return oreMin <= totOre && passeggeriMax >= totPasseggeri;
    }
    
    /**
     * Condizioni:
     * - Almeno 2 viaggi hanno destinazione d
     * - Il numero totale di passeggeri che partecipano a viaggi con destinazione d è maggiore di passeggeriMin
     * @param passeggeriMin
     * @return restituisce la lista delle destinzaioni che soddisfano le condizioni
     */
    public LinkedList<String> destinazioniRichieste(int passeggeriMin) {
        LinkedList<String> res = new LinkedList<>();
        LinkedList<String> destinazioni = getDestinazioni();
        
        for (Iterator<String> it=destinazioni.iterator(); it.hasNext(); ) {
            String curr = it.next();
            int count = 0;
            int totPasseggeri = 0;
            for (Viaggio v : listaViaggi) {
                if (v.getDestinazione().equals(curr)) {
                    totPasseggeri += v.getNumPasseggeri();
                    count++;
                }
            } 
            if (count >= 2 && passeggeriMin < totPasseggeri)
                res.add(curr);
        }
        return res;
    }
    private LinkedList<String> getDestinazioni() {
        LinkedList<String> res = new LinkedList<>();
        for (Viaggio v : listaViaggi) {
            if (!res.contains(v.getDestinazione()))
                res.add(v.getDestinazione());
        }
        return res;
    }

    /**
     * Condizione:
     * - I viaggi non devono avere destinazioni in comune con i viaggi gestiti dal conducente con nome "conducente"
     * @param conducente
     * @return restituisce la lista dei nomi distinti dei conducenti che soddisfano la condizione
     */
    public LinkedList<String> conducentiDiversi(String conducente) {
        LinkedList<String> res = new LinkedList<>();
        LinkedList<String> destConducente = destConducente(conducente);

        for (Conducente c : listaConducenti) {
            if (!c.getNome().equals(conducente)) {
                LinkedList<String> destC = destConducente(c.getNome());
                for (String d : destConducente) {
                    if (!destC.contains(d) && !res.contains(c.getNome()))
                        res.add(c.getNome());
                }
            }
        }
        return res;
    }
    private LinkedList<String> destConducente(String nome) {
        LinkedList<String> res = new LinkedList<>();
        for (Conducente c : listaConducenti) {
            if (c.getNome().equals(nome)) {
                for (Viaggio v : listaViaggi) {
                    if (c.getViaggi().contains(v.getCodice()) && !res.contains(v.getDestinazione()))
                        res.add(v.getDestinazione());                   
                }
                break;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        LinkedList<Viaggio> listaViaggi = new LinkedList<>();
		Viaggio v1 = new Viaggio("V1", "Roma", 5, 70);
		Viaggio v2 = new Viaggio("V2", "Roma", 6, 40);
		Viaggio v3 = new Viaggio("V3", "Salerno", 4, 50);
		Viaggio v4 = new Viaggio("V4", "Salerno", 4, 70);
		Viaggio v5 = new Viaggio("V5", "Reggio Calabria", 3, 50);
		Viaggio v6 = new Viaggio("V6", "Roma", 5, 40);
		listaViaggi.add(v1);
		listaViaggi.add(v2);
		listaViaggi.add(v3);
		listaViaggi.add(v4);
		listaViaggi.add(v5);
		listaViaggi.add(v6);


		LinkedList<Conducente> listaConducenti = new LinkedList<>();

		LinkedList<String> s1 = new LinkedList<>();
		s1.add("V1");
		s1.add("V3");
		s1.add("V6");
		Conducente c1 = new Conducente("Rossi", s1);

		LinkedList<String> s2 = new LinkedList<>();
		s2.add("V2");
		Conducente c2 = new Conducente("Bianchi", s2);

		LinkedList<String> s3 = new LinkedList<>();
		s3.add("V4");
        s3.add("V5");
		Conducente c3 = new Conducente("Verdi", s3);

		listaConducenti.add(c1);
		listaConducenti.add(c2);
		listaConducenti.add(c3);

		Sistema s = new Sistema(listaViaggi, listaConducenti);
    
        IO.println(s.verifica(6, 180));
        IO.println(s.destinazioniRichieste(130));
        IO.println(s.conducentiDiversi("Bianchi"));
    }
}
