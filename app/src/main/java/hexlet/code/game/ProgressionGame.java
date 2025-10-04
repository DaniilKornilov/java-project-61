package hexlet.code.game;

import hexlet.code.Engine;
import hexlet.code.RandomUtils;

import java.util.Scanner;

import static hexlet.code.game.GameConstants.DELIMITER;

public class ProgressionGame {
    private static final String QUESTION = "What number is missing in the progression?";
    private static final String PLACEHOLDER = "..";

    private ProgressionGame() {
    }

    public static void play(Scanner scanner) {
        Engine.play(scanner, QUESTION, ProgressionGame::generateQuestion, ProgressionGame::calculateCorrectAnswer);
    }

    private static String calculateCorrectAnswer(String question) {
        String[] parts = question.split(DELIMITER);

        int missingIndex = -1;
        for (int i = 0; i < parts.length; i++) {
            if (PLACEHOLDER.equals(parts[i])) {
                missingIndex = i;
                break;
            }
        }

        int step;
        int missingValue;

        if (missingIndex == 0) {
            // Missing at start
            step = Integer.parseInt(parts[2]) - Integer.parseInt(parts[1]);
            missingValue = Integer.parseInt(parts[1]) - step;
        } else if (missingIndex == parts.length - 1) {
            // Missing at end
            step = Integer.parseInt(parts[parts.length - 2]) - Integer.parseInt(parts[parts.length - 3]);
            missingValue = Integer.parseInt(parts[parts.length - 2]) + step;
        } else {
            // Missing in the middle
            int prev = Integer.parseInt(parts[missingIndex - 1]);
            int next = Integer.parseInt(parts[missingIndex + 1]);
            missingValue = (prev + next) / 2;
        }
        return String.valueOf(missingValue);
    }

    private static String generateQuestion() {
        int numberOfElements = RandomUtils.generateNumberOfElementsInProgression();
        int step = RandomUtils.generateNumber(10);
        int start = RandomUtils.generateNumber(100);
        int exceptionIndex = RandomUtils.generateNumber(numberOfElements);

        String[] progression = new String[numberOfElements];
        for (int i = 0; i < numberOfElements; i++) {
            if (i == exceptionIndex) {
                progression[i] = PLACEHOLDER;
            } else {
                progression[i] = String.valueOf(start + i * step);
            }
        }

        return String.join(DELIMITER, progression);
    }
}
