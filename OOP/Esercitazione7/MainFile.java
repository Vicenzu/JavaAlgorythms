package Esercitazione7;

import java.io.*;

public class MainFile{
    public static Soldi carica(String path) {
        BufferedReader br = null;
        Soldi res = new SoldiList();
        try {
            br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine())!= null) {
                String[] splitted = line.split("#");
                String pezzi = splitted[0];
                String taglio = splitted[1].replace("$","");
                DenaroConcreto d = new DenaroConcreto(Double.parseDouble(taglio), Integer.parseInt(pezzi));
                res.add(d);
            }
        } catch (IOException e) {
            System.out.println("Errore");
        }
        return res;
    }

    public static void salva(Soldi s, String path) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
            for (Denaro d : s) {
                bw.write(d.getQuantita()+"#"+d.getValore()+"$");
                bw.newLine();
            }
        }catch (IOException e) {
            System.out.println("Errore");
        }
    }



    public static void main(String[] args) {
        String path = "money.txt";
        Soldi sl = new SoldiLC();
        Soldi sl2 = new SoldiLC();
        sl.add(new DenaroConcreto(0.01,10));
        sl.add(new DenaroConcreto(0.1,10));
        sl.add(new DenaroConcreto(0.5,10));
        sl.add(new DenaroConcreto(0.1,10));
        sl.add(new DenaroConcreto(0.5,10));
        salva(sl,path);
        System.out.println(sl);

        sl2.add(new DenaroConcreto(0.01,40));
        sl2.add(new DenaroConcreto(0.1,50));
        sl2.add(new DenaroConcreto(0.5,12));

        System.out.println(sl);
        System.out.println(sl2);

        sl.paga_mi(sl2,sl);

        System.out.println(sl);

        Soldi s2=carica(path);
        System.out.println(s2);
    }
}
