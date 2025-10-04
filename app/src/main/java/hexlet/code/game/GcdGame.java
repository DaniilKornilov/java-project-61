package hexlet.code.game;

import hexlet.code.Engine;
import hexlet.code.RandomUtils;

import java.util.Scanner;

import static hexlet.code.game.GameConstants.DELIMITER;

public final class GcdGame {
    private static final String QUESTION = "Find the greatest common divisor of given numbers.";
    private static final int MAX_NUMBER_EXCLUSIVE = 100;

    private GcdGame() {
    }

    public static void play(Scanner scanner) {
        Engine.play(scanner, QUESTION, GcdGame::generateQuestion, GcdGame::calculateCorrectAnswer);
    }

    private static String calculateCorrectAnswer(String question) {
        String[] parts = question.split(DELIMITER);
        int num1 = Integer.parseInt(parts[0]);
        int num2 = Integer.parseInt(parts[1]);

        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }

        return String.valueOf(num1);
    }

    private static String generateQuestion() {
        return RandomUtils.generateNumber(MAX_NUMBER_EXCLUSIVE)
                + DELIMITER
                + RandomUtils.generateNumber(MAX_NUMBER_EXCLUSIVE);
    }
}
