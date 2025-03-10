package Recuperare;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    public record Persona(String nome, String cognome, int eta) {
        public Persona {
            if (eta < 0) {
                throw new IllegalArgumentException();
            }
        }
    }


    public static void salvaPersoneDaLista(List<Persona> list, String filepath) {
        if (list == null || list.isEmpty()) {
            return;
        }

        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(filepath));
            for (Persona p : list) {
                bw.write(p.nome() + "." + p.cognome() + "." + p.eta() + "\n");
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }


    public static void caricaPersoneSuLista(List<Persona> list, String filepath) {
        Pattern pattern = Pattern.compile("^(\\D+)\\.(\\D+)\\.(\\d+)$");
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filepath));

            String line = br.readLine();
            while (line != null) {
                Matcher matcher = pattern.matcher(line);

                if (matcher.find()) {
                    String nome = matcher.group(1);
                    String cognome = matcher.group(2);
                    int eta = Integer.parseInt(matcher.group(3));

                    list.add(new Persona(nome, cognome, eta));
                }

                line = br.readLine();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }


    }

    public static void caricaV2conSplit(List<Persona> list, String filepath) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filepath));

            String line = br.readLine();
            while (line != null) {
                String[] splitLine = line.split("\\.");

                try {
                    String nome = splitLine[0];
                    String cognome = splitLine[1];
                    int eta = Integer.parseInt(splitLine[2]);

                    list.add(new Persona(nome, cognome, eta));
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.err.println(e.getMessage());
                }

                line = br.readLine();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }


    public static void main(String[] args) {
        Persona p1 = new Persona("Francesco", "Giacobbe", 20);
        Persona p2 = new Persona("Isiria", "Agresta", 21);

        String filepath = "Miei/persone.txt";

        List<Persona> l = List.of(p1, p2);

        salvaPersoneDaLista(l, filepath);

        LinkedList<Persona> lCopy = new LinkedList<>();
        caricaPersoneSuLista(lCopy, filepath);
        System.out.println(lCopy);
    }
}
