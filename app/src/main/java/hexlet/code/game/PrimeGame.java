package hexlet.code.game;

import hexlet.code.Engine;
import hexlet.code.RandomUtils;

import java.util.Scanner;

import static hexlet.code.game.GameConstants.NEGATIVE_ANSWER;
import static hexlet.code.game.GameConstants.POSITIVE_ANSWER;

public class PrimeGame {
    private static final String QUESTION = "Answer '" + POSITIVE_ANSWER +
            "' if given number is prime. Otherwise answer '" + NEGATIVE_ANSWER + "'.";
    private static final int MAX_NUMBER_EXCLUSIVE = 100;

    private PrimeGame() {
    }

    public static void play(Scanner scanner) {
        Engine.play(scanner, QUESTION, PrimeGame::generateQuestion, PrimeGame::calculateCorrectAnswer);
    }

    private static String calculateCorrectAnswer(String question) {
        return (isPrime(Integer.parseInt(question))) ? POSITIVE_ANSWER : NEGATIVE_ANSWER;
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false; // 0 and 1 are not prime
        }
        if (number <= 3) {
            return true; // 2 and 3 are prime
        }
        if (number % 2 == 0 || number % 3 == 0) {
            return false; // eliminate even numbers and multiples of 3
        }

        // Check divisibility using 6k ± 1 optimization
        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }

    private static String generateQuestion() {
        return String.valueOf(RandomUtils.generateNumber(MAX_NUMBER_EXCLUSIVE));
    }
}
