package hexlet.code.game;

import hexlet.code.Engine;
import hexlet.code.RandomUtils;

import java.util.Arrays;
import java.util.Scanner;

public class GcdGame {
    private static final String QUESTION = "Find the greatest common divisor of given numbers.";

    private GcdGame() {
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
