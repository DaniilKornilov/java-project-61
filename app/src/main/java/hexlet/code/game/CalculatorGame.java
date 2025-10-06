package hexlet.code.game;

import hexlet.code.Engine;
import hexlet.code.RandomUtils;

import static hexlet.code.Engine.ANSWER_INDEX;
import static hexlet.code.Engine.QUESTION_INDEX;
import static hexlet.code.Engine.ROUNDS_TO_WIN;
import static hexlet.code.game.GameConstants.DELIMITER;
import static hexlet.code.game.GameConstants.EMPTY_STRING;

public final class CalculatorGame {
    private static final String QUESTION = "What is the result of the expression?";
    private static final int MAX_NUMBER_EXCLUSIVE = 100;

    private CalculatorGame() {
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
        String[] parts = question.replaceAll(DELIMITER, EMPTY_STRING).split("([+\\-*])");
        int num1 = Integer.parseInt(parts[0]);
        int num2 = Integer.parseInt(parts[1]);
        char op = question.charAt(parts[0].length() + 1);

        return String.valueOf(calculateExpression(num1, num2, op));
    }

    private static int calculateExpression(int num1, int num2, char op) {
        return switch (op) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            default -> throw new IllegalArgumentException("Unknown operator: " + op);
        };
    }

    private static String generateQuestion() {
        return RandomUtils.generateNumber(MAX_NUMBER_EXCLUSIVE)
                + DELIMITER
                + RandomUtils.generateRandomOperation()
                + DELIMITER
                + RandomUtils.generateNumber(MAX_NUMBER_EXCLUSIVE);
    }
}
