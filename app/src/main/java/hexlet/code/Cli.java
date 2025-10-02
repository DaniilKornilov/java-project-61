package hexlet.code;

import java.util.Scanner;

public class Cli {
    static void greeting() {
        System.out.println("Welcome to the Brain Games!");
        Scanner scanner = new Scanner(System.in);
        System.out.print("May I have your name?: ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
    }
}
