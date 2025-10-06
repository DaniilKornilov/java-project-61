package hexlet.code.game;

import hexlet.code.Engine;
import hexlet.code.RandomUtils;

import static hexlet.code.Engine.ANSWER_INDEX;
import static hexlet.code.Engine.QUESTION_INDEX;
import static hexlet.code.Engine.ROUNDS_TO_WIN;
import static hexlet.code.game.GameConstants.DELIMITER;

public final class GcdGame {
    private static final String QUESTION = "Find the greatest common divisor of given numbers.";
    private static final int MAX_NUMBER_EXCLUSIVE = 100;

    private GcdGame() {
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
        int num1 = Integer.parseInt(parts[0]);
        int num2 = Integer.parseInt(parts[1]);

        return String.valueOf(findGcd(num1, num2));
    }

    private static int findGcd(int num1, int num2) {
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }

        return num1;
    }

    private static String generateQuestion() {
        return RandomUtils.generateNumber(MAX_NUMBER_EXCLUSIVE)
                + DELIMITER
                + RandomUtils.generateNumber(MAX_NUMBER_EXCLUSIVE);
    }
}
