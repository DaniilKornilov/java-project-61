package hexlet.code.game;

import hexlet.code.Engine;
import hexlet.code.RandomUtils;

import java.util.Scanner;

import static hexlet.code.game.GameConstants.NEGATIVE_ANSWER;
import static hexlet.code.game.GameConstants.POSITIVE_ANSWER;

public final class EvenGame {
    private static final String QUESTION = "Answer '" + POSITIVE_ANSWER
            + "' if the number is even, otherwise answer '" + NEGATIVE_ANSWER + "'.";
    private static final int MAX_NUMBER_EXCLUSIVE = 100;

    private EvenGame() {
    }

    public static void play(Scanner scanner) {
        Engine.play(scanner, QUESTION, EvenGame::generateQuestion, EvenGame::calculateCorrectAnswer);
    }

    private static String calculateCorrectAnswer(String question) {
        return (Integer.parseInt(question) % 2 == 0) ? POSITIVE_ANSWER : NEGATIVE_ANSWER;
    }

    private static String generateQuestion() {
        return String.valueOf(RandomUtils.generateNumber(MAX_NUMBER_EXCLUSIVE));
    }
}
