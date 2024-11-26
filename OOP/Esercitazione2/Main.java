package Esercitazione2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Inserisci un numero, 1 creazione documento, 2 visualizzazione documento");
        System.out.println("Inserisci un numero negativo per finire");
        n = input.nextInt();
        input.nextLine();

        while (n > 0) {
            switch (n) {
                case 1: {
                    System.out.println("Inserisci tipo: ");
                    String tipo = input.nextLine();
                    if (tipo.equalsIgnoreCase("Lettera")) {
                        System.out.println("Mittente: ");
                        String mittente = input.nextLine();
                        System.out.println("Destinatario: ");
                        String destinatario = input.nextLine();
                        System.out.println("Testo: ");
                        String testo = input.nextLine();
                        System.out.println("Nome Proprietario: ");
                        String nomeProprietario = input.nextLine();
                        System.out.println("Firma: ");
                        String firma = input.nextLine();
                        System.out.println("Codice Firma: ");
                        int codiceFirma = input.nextInt();
                        input.nextLine();

                        Letter l = new Letter(testo, nomeProprietario, firma, codiceFirma, mittente, destinatario);
                        break;
                    } else if (tipo.equalsIgnoreCase("Report")) {
                        System.out.println("Testo: ");
                        String testo = input.nextLine();
                        System.out.println("Nome Proprietario: ");
                        String nomeProprietario = input.nextLine();
                        System.out.println("Firma: ");
                        String firma = input.nextLine();
                        System.out.println("Codice Firma: ");
                        int codiceFirma = input.nextInt();
                        input.nextLine();
                        System.out.println("Destinatario: ");
                        String destinatario = input.nextLine();
                        System.out.println("Quanti Parametri: ");
                        int quantiParametri = input.nextInt();
                        input.nextLine();
                        String[] parametri = new String[quantiParametri];
                        System.out.println("Inserisci i parametri: ");
                        for (int i = 0; i < parametri.length; i++) {
                            parametri[i] = input.nextLine();
                        }
                        System.out.println("Raggiunti: ");
                        boolean[] raggiunti = new boolean[quantiParametri];
                        for (int i = 0; i < parametri.length; i++) {
                            raggiunti[i] = input.nextBoolean();
                        }

                        Report r = new Report(testo, nomeProprietario, firma, codiceFirma, destinatario, parametri, raggiunti);
                        System.out.println("Report creato");
                        break;
                    }
                } case 2: {
                    System.out.println("Stampato");
                    break;
                }
            }
            n = input.nextInt();
        }
    }
}
