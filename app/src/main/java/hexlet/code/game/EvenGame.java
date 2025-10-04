package hexlet.code.game;

import hexlet.code.Engine;
import hexlet.code.RandomUtils;

import java.util.Arrays;
import java.util.Scanner;

public class EvenGame {
    private static final String QUESTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    private EvenGame() {
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
        return (Integer.parseInt(question) % 2 == 0) ? "yes" : "no";
    }

    private static String generateQuestion() {
        return String.valueOf(RandomUtils.generateNumber(100));
    }
}
