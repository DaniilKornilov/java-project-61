package hexlet.code.game;

import hexlet.code.Engine;
import hexlet.code.RandomUtils;

import java.util.Scanner;

import static hexlet.code.game.GameConstants.DELIMITER;
import static hexlet.code.game.GameConstants.EMPTY_STRING;

public final class CalculatorGame {
    private static final String QUESTION = "What is the result of the expression?";
    private static final int MAX_NUMBER_EXCLUSIVE = 100;

    private CalculatorGame() {
    }

    public static void play(Scanner scanner) {
        Engine.play(scanner, QUESTION, CalculatorGame::generateQuestion, CalculatorGame::calculateCorrectAnswer);
    }

    private static String calculateCorrectAnswer(String question) {
        String[] parts = question.replaceAll(DELIMITER, EMPTY_STRING).split("([+\\-*])");
        int num1 = Integer.parseInt(parts[0]);
        int num2 = Integer.parseInt(parts[1]);
        char op = question.charAt(parts[0].length() + 1);

        int result = switch (op) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            default -> throw new IllegalArgumentException("Unknown operator: " + op);
        };
        return String.valueOf(result);
    }

    private static String generateQuestion() {
        return RandomUtils.generateNumber(MAX_NUMBER_EXCLUSIVE)
                + DELIMITER
                + RandomUtils.generateRandomOperation()
                + DELIMITER
                + RandomUtils.generateNumber(MAX_NUMBER_EXCLUSIVE);
    }
}
