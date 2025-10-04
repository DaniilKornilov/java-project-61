package hexlet.code.game;

import hexlet.code.Engine;
import hexlet.code.RandomUtils;

import java.util.Arrays;
import java.util.Scanner;

public class CalculatorGame {
    private static final String QUESTION = "What is the result of the expression?";

    private CalculatorGame() {
    }

    public static void play(Scanner scanner) {
        String[] questions = generateQuestions();
        String[] correctAnswers = calculateCorrectAnswers(questions);

        Engine.play(scanner, QUESTION, questions, correctAnswers);
    }

    private static String[] calculateCorrectAnswers(String[] questions) {
        String[] correctAnswers = new String[Engine.ROUNDS_TO_WIN];
        Arrays.setAll(correctAnswers, i -> calculateCorrectAnswer(questions[i]));
        return correctAnswers;
    }

    private static String[] generateQuestions() {
        String[] questions = new String[Engine.ROUNDS_TO_WIN];
        Arrays.setAll(questions, i -> generateQuestion());
        return questions;
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
