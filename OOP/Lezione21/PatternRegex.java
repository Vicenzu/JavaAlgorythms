package Lezione21;

import java.util.Scanner;
import java.util.regex.*;

public class PatternRegex {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile(args[0]);

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                String match = matcher.group();
                System.out.println(matcher.start() + ":" + matcher.end() + "[" + "...");
            }
        }
        

    }
}
