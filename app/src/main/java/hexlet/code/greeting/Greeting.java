package hexlet.code.greeting;

import java.util.Scanner;

public final class Greeting {
    private Greeting() {
    }

    public static String greetPlayerAndReturnName() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name?: ");

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        System.out.println("Hello, " + name + "!");
        return name;
    }
}
