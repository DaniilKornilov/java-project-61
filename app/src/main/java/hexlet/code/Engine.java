package hexlet.code;

import hexlet.code.greeting.Greeting;

import java.util.Scanner;

public final class Engine {
    public static final int ROUNDS_TO_WIN = 3;
    private static final int QUESTION_INDEX = 0;

    private static final int ANSWER_INDEX = 1;

    private Engine() {
    }

    public static void play(String question, String[][] questionsToAnswers) {
        String name = Greeting.greetPlayerAndReturnName();
        System.out.println(question);

        Scanner scanner = new Scanner(System.in);
        for (String[] questionToAnswer : questionsToAnswers) {
            String generatedQuestion = questionToAnswer[QUESTION_INDEX];
            String correctAnswer = questionToAnswer[ANSWER_INDEX];

            System.out.println("Question: " + generatedQuestion);
            String answer = scanner.nextLine();

            if (!validatePlayersAnswer(answer, correctAnswer, name)) {
                return;
            }
        }

        System.out.println("Congratulations, " + name + "!");
    }

    private static boolean validatePlayersAnswer(String answer, String correctAnswer, String playerName) {
        if (answer.equals(correctAnswer)) {
            System.out.println("Correct!");
            return true;
        } else {
            System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
            System.out.println("Let's try again, " + playerName + "!");
            return false;
        }
    }
}
