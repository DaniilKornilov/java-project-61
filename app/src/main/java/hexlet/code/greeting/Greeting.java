package hexlet.code.greeting;

import java.util.Scanner;

public final class Greeting {
    private Greeting() {
    }

    public static String greetPlayerAndReturnName(Scanner scanner) {
        System.out.println("Welcome to the Brain Games!");

        System.out.print("May I have your name?: ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");

        return name;
    }
}
