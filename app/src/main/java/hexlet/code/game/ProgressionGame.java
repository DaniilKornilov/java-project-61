package hexlet.code.game;

import hexlet.code.Engine;
import hexlet.code.RandomUtils;

import static hexlet.code.Engine.ANSWER_INDEX;
import static hexlet.code.Engine.QUESTION_INDEX;
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
            String question = generateQuestion();
            questionsToAnswers[i][QUESTION_INDEX] = question;
            questionsToAnswers[i][ANSWER_INDEX] = calculateCorrectAnswer(question);
        }

        Engine.play(QUESTION, questionsToAnswers);
    }

    private static String calculateCorrectAnswer(String question) {
        String[] parts = question.split(DELIMITER);

        int missingIndex = findMissingIndexOfProgression(parts);
        int missingValue = findMissingNumberOfProgression(parts, missingIndex);
        return String.valueOf(missingValue);
    }

    private static int findMissingIndexOfProgression(String[] progression) {
        int missingIndex = -1;
        for (int i = 0; i < progression.length; i++) {
            if (PLACEHOLDER.equals(progression[i])) {
                missingIndex = i;
                break;
            }
        }
        return missingIndex;
    }

    private static int findMissingNumberOfProgression(String[] progression, int missingIndex) {
        int step;
        int missingValue;
        final int stepDifference = 1;
        if (missingIndex == 0) {
            // Missing at start
            step = Integer.parseInt(progression[2]) - Integer.parseInt(progression[1]);
            missingValue = Integer.parseInt(progression[1]) - step;
        } else if (missingIndex == progression.length - 1) {
            // Missing at end
            step = Integer.parseInt(progression[progression.length - stepDifference - 1])
                    - Integer.parseInt(progression[progression.length - stepDifference - 2]);
            missingValue = Integer.parseInt(progression[progression.length - stepDifference - 1]) + step;
        } else {
            // Missing in the middle
            int prev = Integer.parseInt(progression[missingIndex - stepDifference]);
            int next = Integer.parseInt(progression[missingIndex + stepDifference]);
            missingValue = (prev + next) / 2;
        }
        return missingValue;
    }

    private static String generateQuestion() {
        String[] progression = generateProgression();
        return String.join(DELIMITER, progression);
    }

    private static String[] generateProgression() {
        int numberOfElements = RandomUtils.generateNumberOfElementsInProgression();
        int step = RandomUtils.generateNumber(MAX_STEP_EXCLUSIVE);
        int start = RandomUtils.generateNumber(MAX_NUMBER_EXCLUSIVE);
        int exceptionIndex = RandomUtils.generateNumber(numberOfElements);

        String[] progression = new String[numberOfElements];
        for (int i = 0; i < numberOfElements; i++) {
            if (i == exceptionIndex) {
                progression[i] = PLACEHOLDER;
            } else {
                progression[i] = String.valueOf(start + i * step);
            }
        }
        return progression;
    }
}
