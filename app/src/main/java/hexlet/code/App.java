package hexlet.code;

import hexlet.code.game.CalculatorGame;
import hexlet.code.game.EvenGame;
import hexlet.code.game.GcdGame;
import hexlet.code.game.PrimeGame;
import hexlet.code.game.ProgressionGame;
import hexlet.code.greeting.Greeting;

import java.util.Scanner;

public final class App {
    private static final int GREET_CHOICE = 1;
    private static final int EVEN_GAME_CHOICE = 2;
    private static final int CALC_GAME_CHOICE = 3;
    private static final int GCD_GAME_CHOICE = 4;
    private static final int PROGRESSION_GAME_CHOICE = 5;
    private static final int PRIME_GAME_CHOICE = 6;
    private static final int EXIT_CHOICE = 0;

    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println(GREET_CHOICE + " - Greet");
        System.out.println(EVEN_GAME_CHOICE + " - EvenGame");
        System.out.println(CALC_GAME_CHOICE + " - Calc");
        System.out.println(GCD_GAME_CHOICE + " - GCD");
        System.out.println(PROGRESSION_GAME_CHOICE + " - Progression");
        System.out.println(PRIME_GAME_CHOICE + " - Prime");
        System.out.println(EXIT_CHOICE + " - Exit");

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case EXIT_CHOICE:
                    break;
                case GREET_CHOICE:
                    Greeting.greetPlayerAndReturnName(scanner);
                    break;
                case EVEN_GAME_CHOICE:
                    EvenGame.play(scanner);
                    break;
                case CALC_GAME_CHOICE:
                    CalculatorGame.play(scanner);
                    break;
                case GCD_GAME_CHOICE:
                    GcdGame.play(scanner);
                    break;
                case PROGRESSION_GAME_CHOICE:
                    ProgressionGame.play(scanner);
                    break;
                case PRIME_GAME_CHOICE:
                    PrimeGame.play(scanner);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
