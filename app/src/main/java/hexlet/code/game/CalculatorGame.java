package hexlet.code.game;

import hexlet.code.Engine;
import hexlet.code.RandomUtils;

import java.util.Scanner;

public class CalculatorGame {
    private static final String QUESTION = "What is the result of the expression?";

    public static void play(Scanner scanner) {
        String[] questions = new String[Engine.ROUNDS_TO_WIN];
        String[] correctAnswers = new String[Engine.ROUNDS_TO_WIN];
        for (int i = 0; i < Engine.ROUNDS_TO_WIN; i++) {
            questions[i] = generateQuestion();
            correctAnswers[i] = calculateCorrectAnswer(questions[i]);
        }

        Engine.play(scanner, QUESTION, questions, correctAnswers);
    }

    private static String calculateCorrectAnswer(String question) {
        String[] parts = question.split("([+\\-*])");
        int num1 = Integer.parseInt(parts[0]);
        int num2 = Integer.parseInt(parts[1]);
        char op = question.charAt(parts[0].length());

        int result = switch (op) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            default -> throw new IllegalArgumentException("Unknown operator: " + op);
        };
        return String.valueOf(result);
    }

    private static String generateQuestion() {
        return RandomUtils.generateNumber(100) +
                RandomUtils.generateRandomOperation() +
                RandomUtils.generateNumber(100);
    }
}
