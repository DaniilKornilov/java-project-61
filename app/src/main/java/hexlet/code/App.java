package hexlet.code;

import hexlet.code.game.CalculatorGame;
import hexlet.code.game.EvenGame;
import hexlet.code.game.GcdGame;
import hexlet.code.game.PrimeGame;
import hexlet.code.game.ProgressionGame;
import hexlet.code.greeting.Greeting;

import java.util.Scanner;

public final class App {

    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - EvenGame");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    break;
                case 1:
                    Greeting.greetPlayerAndReturnName(scanner);
                    break;
                case 2:
                    EvenGame.play(scanner);
                    break;
                case 3:
                    CalculatorGame.play(scanner);
                    break;
                case 4:
                    GcdGame.play(scanner);
                    break;
                case 5:
                    ProgressionGame.play(scanner);
                    break;
                case 6:
                    PrimeGame.play(scanner);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
