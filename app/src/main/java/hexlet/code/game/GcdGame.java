package hexlet.code.game;

import hexlet.code.Engine;
import hexlet.code.RandomUtils;

import java.util.Scanner;

public class GcdGame {
    private static final String QUESTION = "Find the greatest common divisor of given numbers.";

    private GcdGame() {
    }

    public static void play(Scanner scanner) {
        Engine.play(scanner, QUESTION, GcdGame::generateQuestion, GcdGame::calculateCorrectAnswer);
    }

    private static String calculateCorrectAnswer(String question) {
        String[] parts = question.split(" ");
        int num1 = Integer.parseInt(parts[0]);
        int num2 = Integer.parseInt(parts[1]);

        return String.valueOf(gcdByEuclidsAlgorithm(num1, num2));
    }

    private static int gcdByEuclidsAlgorithm(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcdByEuclidsAlgorithm(n2, n1 % n2);
    }

    private static String generateQuestion() {
        return RandomUtils.generateNumber(100) +
                " " +
                RandomUtils.generateNumber(100);
    }
}
