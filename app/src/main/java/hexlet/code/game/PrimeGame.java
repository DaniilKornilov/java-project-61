package hexlet.code.game;

import hexlet.code.Engine;
import hexlet.code.RandomUtils;

import java.util.Scanner;

import static hexlet.code.game.GameConstants.NEGATIVE_ANSWER;
import static hexlet.code.game.GameConstants.POSITIVE_ANSWER;

public final class PrimeGame {
    private static final String QUESTION = "Answer '" + POSITIVE_ANSWER
            + "' if given number is prime. Otherwise answer '" + NEGATIVE_ANSWER + "'.";
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
        final int minPrimeCheck = 2;
        if (number < minPrimeCheck) {
            return false; // 0 and 1 are not prime
        }

        final int maxPrimeCheck = 3;
        if (number <= maxPrimeCheck) {
            return true; // 2 and 3 are prime
        }

        final int divisorTwo = 2;
        final int divisorThree = 3;
        if (number % divisorTwo == 0 || number % divisorThree == 0) {
            return false; // eliminate even numbers and multiples of 3
        }

        final int sixKStep = 6;
        final int sixKOffset = 2;
        final int sixKInitialPrimeCheck = 5;
        // Check divisibility using 6k ± 1 optimization
        for (int i = sixKInitialPrimeCheck; i * i <= number; i += sixKStep) {
            if (number % i == 0 || number % (i + sixKOffset) == 0) {
                return false;
            }
        }

        return true;
    }

    private static String generateQuestion() {
        return String.valueOf(RandomUtils.generateNumber(MAX_NUMBER_EXCLUSIVE));
    }
}
