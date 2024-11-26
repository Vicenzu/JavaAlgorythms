package Esercitazione6;
//Prova23012023
import java.util.*;

import IO.IO;
public class Sistema {
    private LinkedList<Appartamento> appartamenti;
    private LinkedList<Impianto> impianti;

    public Sistema(LinkedList<Appartamento> appartamenti, LinkedList<Impianto> impianti) {
        this.appartamenti = new LinkedList<>();
        this.impianti = new LinkedList<>();

        for (Impianto im : impianti) {
            this.impianti.add(im);
        }
        
        for (Appartamento ap : appartamenti) {
            this.appartamenti.add(ap);
        }
    }

    public LinkedList<String> scaleUnicoTipo() {
        LinkedList<String> res = new LinkedList<>();

        LinkedList<String> scale = getScale();

        for (String s : scale) {
            if (almenoUno(s) && stessoTipo(s))
                res.add(s);
        }
        return res;
    }

    private LinkedList<String> getScale() {
        LinkedList<String> res = new LinkedList<>();
        for (Appartamento a : appartamenti) {
            if (!res.contains(a.getScala()))
                res.add(a.getScala());
        }
        return res;
    }

    private boolean almenoUno(String s) {
        for (Impianto im : impianti) {
            for (Appartamento ap : appartamenti) {
                if (ap.getCodice().equals(im.getAppartamento()) && ap.getScala().equals(s))
                    return true;
            }
        }
        return false;
    }

    private boolean stessoTipo(String s) {
        String tipo = "";
        for (Impianto i : impianti) {
            for (Appartamento a : appartamenti) {
                if (a.getCodice().equals(i.getAppartamento()) && a.getScala().equals(s))
                    if (tipo.equals(""))
                        tipo = i.getTipo();
                    else if (!tipo.equals(i.getTipo()))
                        return false;
            }
        }
        return true;
    }

    public String tecnicoMax() {
        String max = "";
        int incassoMax = -1;

        LinkedList<String> tecnici = getTecnici();

        for (String t : tecnici) {
            int i = contaIncasso(t);
            if (i>incassoMax) {
                incassoMax = i;
                max = t;
            }
        }
        return max;
    }

    private LinkedList<String> getTecnici() {
        LinkedList<String> res = new LinkedList<>();

        for (Impianto i : impianti) {
            for (String t : i.getTecnici()) {
                if (!res.contains(t))
                    res.add(t);
            }
        }
        return res;
    }

    private int contaIncasso(String tecnico) {
        int incasso = 0;

        for (Impianto i : impianti) {
            if (i.getTecnici().contains(tecnico)) {
                incasso += i.getPrezzoInstallazione();
            }
        }
        return incasso;
    }

    public String scalaSimile(String cod, int d1, int d2) {
        LinkedList<String> scale = getScale();
        
        int ni = getNumeroInstallazioni(cod, d1, d2);

        for (String s : scale) {
            if (!s.equals(cod)) {
                int n = getNumeroInstallazioni(s, d1, d2);

                if (n == ni) 
                    return s;
            }
        }
        return null;
    }

    private int getNumeroInstallazioni(String cod, int d1, int d2) {
        int count = 0; 

        for (Impianto i : impianti) {
            if (i.getDataInstallazione() >= d1 && i.getDataInstallazione() <= d2) {
                for (Appartamento a : appartamenti) {
                    if (a.getCodice().equals(i.getAppartamento()) && a.getScala().equals(cod))
                        count++;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        LinkedList<Appartamento> lista_A = new LinkedList<Appartamento>();
		Appartamento a1 = new Appartamento("A1", "S1");
		Appartamento a2 = new Appartamento("A2", "S1");
		Appartamento a3 = new Appartamento("A3", "S2");
		Appartamento a4 = new Appartamento("A4", "S2");
		Appartamento a5 = new Appartamento("A5", "S3");
		Appartamento a6 = new Appartamento("A6", "S3");
		lista_A.add(a1);
		lista_A.add(a2);
		lista_A.add(a3);
		lista_A.add(a4);
		lista_A.add(a5);
		lista_A.add(a6);

		LinkedList<Impianto> lista_I = new LinkedList<Impianto>();
		LinkedList<String> Tecnici1 = new LinkedList<>();
		Tecnici1.add("Bianchi");
		Tecnici1.add("Verdi");
		LinkedList<String> Tecnici2 = new LinkedList<>();
		Tecnici2.add("Verdi");
		Tecnici2.add("Rossi");
		LinkedList<String> Tecnici3 = new LinkedList<>();
		Tecnici3.add("Bianchi");
		Tecnici3.add("Rossi");
		LinkedList<String> Tecnici4 = new LinkedList<>();
		Tecnici4.add("Verdi");
		LinkedList<String> Tecnici5 = new LinkedList<>();
		Tecnici3.add("Bianchi");
		Impianto i1 = new Impianto("A1",120,10,"fotovoltaico", Tecnici1);
		Impianto i2 = new Impianto("A1",100,10,"solare termico", Tecnici2);
		Impianto i3 = new Impianto("A2",120,10,"solare termico", Tecnici3);
		Impianto i4 = new Impianto("A3",100,10,"fotovoltaico", Tecnici2);
		Impianto i5 = new Impianto("A4",120,10,"fotovoltaico", Tecnici4);
		Impianto i6 = new Impianto("A5",100,10,"fotovoltaico", Tecnici5);
		Impianto i7 = new Impianto("A6",110,10,"solare termico", Tecnici3);
		lista_I.add(i1);
		lista_I.add(i2);
		lista_I.add(i3);
		lista_I.add(i4);
		lista_I.add(i5);
		lista_I.add(i6);
		lista_I.add(i7);

		Sistema s = new Sistema(lista_A, lista_I);
		IO.println(s.scaleUnicoTipo());
    }
}
