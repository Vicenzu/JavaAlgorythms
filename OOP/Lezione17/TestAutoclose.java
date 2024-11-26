package Lezione17;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestAutoclose {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No input file specified");
            System.exit(1);
        }
        FileInputStream fi = null;
        try {
            fi = new FileInputStream(args[0]);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(1);
        }

        /* TRY WITH RESOURCES (con le parentesi), ovvero invoca il close() come finally
        * vanno passati oggetti che implementano Closeable */
        try (Scanner sc = new Scanner(fi)) {
            for (int i = 0; sc.hasNextLine(); i++) {
                System.out.println(i + ": " + sc.nextLine());
            }
        }
    }
}