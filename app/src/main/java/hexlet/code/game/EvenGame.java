package hexlet.code.game;

import hexlet.code.Engine;
import hexlet.code.RandomUtils;

import java.util.Scanner;

public class EvenGame {

    private static final String QUESTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";

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
        return (Integer.parseInt(question) % 2 == 0) ? "yes" : "no";
    }

    private static String generateQuestion() {
        return String.valueOf(RandomUtils.generateNumber(100));
    }
}
