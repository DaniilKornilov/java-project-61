package hexlet.code.game;

import hexlet.code.Engine;
import hexlet.code.RandomUtils;

import static hexlet.code.Engine.ROUNDS_TO_WIN;
import static hexlet.code.game.GameConstants.NEGATIVE_ANSWER;
import static hexlet.code.game.GameConstants.POSITIVE_ANSWER;

public final class EvenGame {
    private static final String QUESTION = "Answer '" + POSITIVE_ANSWER
            + "' if the number is even, otherwise answer '" + NEGATIVE_ANSWER + "'.";
    private static final int MAX_NUMBER_EXCLUSIVE = 100;

    private EvenGame() {
    }

    public static void play() {
        String[][] questionsToAnswers = new String[ROUNDS_TO_WIN][2];
        for (int i = 0; i < ROUNDS_TO_WIN; i++) {
            questionsToAnswers[i] = generateQuestionAnswerPair();
        }

        Engine.play(QUESTION, questionsToAnswers);
    }

    private static String[] generateQuestionAnswerPair() {
        String question = generateQuestion();
        return new String[] {question, calculateCorrectAnswer(question)};
    }

    private static String calculateCorrectAnswer(String question) {
        return isEven(Integer.parseInt(question)) ? POSITIVE_ANSWER : NEGATIVE_ANSWER;
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    private static String generateQuestion() {
        return String.valueOf(RandomUtils.generateNumber(MAX_NUMBER_EXCLUSIVE));
    }
}
