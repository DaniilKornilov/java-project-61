package hexlet.code.game;

import hexlet.code.Engine;
import hexlet.code.RandomUtils;

import static hexlet.code.Engine.ROUNDS_TO_WIN;
import static hexlet.code.game.GameConstants.DELIMITER;

public final class ProgressionGame {
    private static final String QUESTION = "What number is missing in the progression?";
    private static final String PLACEHOLDER = "..";
    private static final int MAX_NUMBER_EXCLUSIVE = 100;
    private static final int MAX_STEP_EXCLUSIVE = 10;

    private ProgressionGame() {
    }

    public static void play() {
        String[][] questionsToAnswers = new String[ROUNDS_TO_WIN][2];
        for (int i = 0; i < ROUNDS_TO_WIN; i++) {
            questionsToAnswers[i] = generateQuestionAnswerPair();
        }

        Engine.play(QUESTION, questionsToAnswers);
    }

    private static String[] generateQuestionAnswerPair() {
        int numberOfElements = RandomUtils.generateNumberOfElementsInProgression();
        int step = RandomUtils.generateNumber(MAX_STEP_EXCLUSIVE);
        int start = RandomUtils.generateNumber(MAX_NUMBER_EXCLUSIVE);
        String[] progression = generateProgression(numberOfElements, step, start);

        int missingNumberIndex = RandomUtils.generateNumber(numberOfElements);
        String answer = progression[missingNumberIndex];
        String question = generateQuestion(progression, missingNumberIndex);

        return new String[]{question, answer};
    }

    private static String generateQuestion(String[] progression, int missingNumberIndex) {
        progression[missingNumberIndex] = PLACEHOLDER;
        return String.join(DELIMITER, progression);
    }

    private static String[] generateProgression(int numberOfElements, int step, int start) {
        String[] progression = new String[numberOfElements];
        for (int i = 0; i < numberOfElements; i++) {
            progression[i] = String.valueOf(start + i * step);
        }
        return progression;
    }
}
