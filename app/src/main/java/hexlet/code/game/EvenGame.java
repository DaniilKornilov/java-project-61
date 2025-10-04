package hexlet.code.game;

import hexlet.code.Engine;
import hexlet.code.RandomUtils;

import java.util.Scanner;

public class EvenGame {
    private static final String QUESTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    private EvenGame() {
    }

    public static void play(Scanner scanner) {
        Engine.play(scanner, QUESTION, EvenGame::generateQuestion, EvenGame::calculateCorrectAnswer);
    }

    private static String calculateCorrectAnswer(String question) {
        return (Integer.parseInt(question) % 2 == 0) ? "yes" : "no";
    }

    private static String generateQuestion() {
        return String.valueOf(RandomUtils.generateNumber(100));
    }
}
